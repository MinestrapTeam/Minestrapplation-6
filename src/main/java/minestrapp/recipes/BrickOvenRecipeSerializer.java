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

public class BrickOvenRecipeSerializer<T extends BrickOvenRecipe> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {

    public final BrickOvenRecipeSerializer.IFactory<T> factory;

    public BrickOvenRecipeSerializer(BrickOvenRecipeSerializer.IFactory<T> factory) {
        this.factory = factory;
    }

    @Override
    public T read(ResourceLocation recipeId, JsonObject json) {
        String s = JSONUtils.getString(json, "group", "");
        JsonElement jsonElement = JSONUtils.isJsonArray(json, "ingredient") ? JSONUtils.getJsonArray(json, "ingredient") : JSONUtils.getJsonObject(json, "ingredient");
        JsonElement jsonElement2 = JSONUtils.isJsonArray(json, "ingredient2") ? JSONUtils.getJsonArray(json, "ingredient2") : JSONUtils.getJsonObject(json, "ingredient2");
        Ingredient ingredient = Ingredient.deserialize(jsonElement);
        Ingredient ingredient2 = Ingredient.deserialize(jsonElement2);
        ItemStack itemStack;

        if(json.get("result").isJsonObject()){
            itemStack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
        } else {
            String sl = JSONUtils.getString(json, "result");
            ResourceLocation rl = new ResourceLocation(sl);
            itemStack = new ItemStack(Registry.ITEM.getValue(rl).orElseThrow(() ->{
                return new IllegalStateException("Item does not exist");
            }));
        }

        return this.factory.create(recipeId, s, ingredient, ingredient2, itemStack);
    }

    @Nullable
    @Override
    public T read(ResourceLocation recipeId, PacketBuffer buffer) {
        String s = buffer.readString(32767);
        Ingredient ingredient = Ingredient.read(buffer);
        Ingredient ingredient2 = Ingredient.read(buffer);
        ItemStack itemstack = buffer.readItemStack();
        return this.factory.create(recipeId, s, ingredient, ingredient2, itemstack);

    }

    @Override
    public void write(PacketBuffer buffer, T recipe) {
        buffer.writeString(recipe.group);
        recipe.ingredient.write(buffer);
        recipe.ingredient2.write(buffer);
        buffer.writeItemStack(recipe.result);
    }

    public interface IFactory<T extends BrickOvenRecipe> {
        T create(ResourceLocation resourceLocation, String group, Ingredient ingredient, Ingredient ingredient2, ItemStack result);
    }

}
