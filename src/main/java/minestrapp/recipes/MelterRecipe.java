package minestrapp.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class MelterRecipe implements IRecipe<RecipeWrapper> {
    public static final IRecipeType<MelterRecipe> melter = IRecipeType.register("melter");

    private final IRecipeType<?> type;
    private final ResourceLocation id;
    final String group;
    final Ingredient ingredient;
    final ItemStack result;
    final boolean needsBucket;

    public MelterRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result, boolean needsBucket) {
        this.type = melter;
        this.id = id;
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;
        this.needsBucket = needsBucket;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        return this.ingredient.test(inv.getStackInSlot(0));
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return this.result.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return result;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return  Recipes.MELTER_RECIPES.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return type;
    }

    public boolean needsBucket(){
        return needsBucket;
    }
}
