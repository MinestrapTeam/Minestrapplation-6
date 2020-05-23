package minestrapp.recipes;

import minestrapp.init.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class BrickOvenRecipe implements IRecipe<RecipeWrapper> {
    public static final IRecipeType<BrickOvenRecipe> oven = IRecipeType.register("brickoven");

    private final IRecipeType<?> type;
    private final ResourceLocation id;
    final String group;
    final Ingredient ingredient;
    final Ingredient ingredient2;
    final ItemStack result;

    public BrickOvenRecipe(ResourceLocation id, String group, Ingredient ingredient, Ingredient ingredient2, ItemStack result) {
        this.type = oven;
        this.id = id;
        this.group = group;
        this.ingredient = ingredient;
        this.ingredient2 = ingredient2;
        this.result = result;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        return (this.ingredient.test(inv.getStackInSlot(0)) && this.ingredient2.test(inv.getStackInSlot(1))) || (this.ingredient.test(inv.getStackInSlot(1)) && this.ingredient2.test(inv.getStackInSlot(0)));
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
        return  Recipes.OVEN_RECIPES.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return type;
    }
}