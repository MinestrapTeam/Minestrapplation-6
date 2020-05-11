package minestrapp.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class MelterRecipeSerializer<T extends MelterRecipe> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {

    private final MelterRecipeSerializer.IFactory<T> factory;

    public MelterRecipeSerializer(MelterRecipeSerializer.IFactory<T> factory) {
        this.factory = factory;
    }


    @Override
    public T read(ResourceLocation recipeId, JsonObject json) {
        String s = JSONUtils.getString(json, "group", "");
        JsonElement jsonElement = JSONUtils.isJsonArray(json, "ingredient") ? JSONUtils.getJsonArray(json, "ingredient") : JSONUtils.getJsonObject(json, "ingredient");
        Ingredient ingredient = Ingredient.deserialize(jsonElement);
        ItemStack itemStack;

        if(json.get("result").isJsonObject()){
            itemStack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
        } else {
            String sl = JSONUtils.getString(json, "result");
            ResourceLocation rl = new ResourceLocation(sl);
            itemStack = new ItemStack(Registry.ITEM.getValue(rl).get());
        }

        boolean bucket = JSONUtils.getBoolean(json, "bucket");

        return this.factory.create(recipeId, s, ingredient, itemStack, bucket);
    }

    @Nullable
    @Override
    public T read(ResourceLocation recipeId, PacketBuffer buffer) {
        String s = buffer.readString(32767);
        Ingredient ingredient = Ingredient.read(buffer);
        ItemStack itemstack = buffer.readItemStack();
        float f = buffer.readFloat();
        int i = buffer.readVarInt();
        boolean bucket = buffer.readBoolean();

        return this.factory.create(recipeId, s, ingredient, itemstack, bucket);

    }

    @Override
    public void write(PacketBuffer buffer, T recipe) {
        buffer.writeString(recipe.group);
        recipe.ingredient.write(buffer);
        buffer.writeItemStack(recipe.result);
        buffer.writeBoolean(recipe.needsBucket);
    }

    interface IFactory<T extends MelterRecipe> {
        T create(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result, boolean needsBucket);
    }

}
