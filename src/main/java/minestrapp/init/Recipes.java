package minestrapp.init;

import minestrapp.Reference;
import minestrapp.recipes.BrickOvenRecipe;
import minestrapp.recipes.BrickOvenRecipeSerializer;
import minestrapp.recipes.MelterRecipe;
import minestrapp.recipes.MelterRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Recipes {

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPES = new DeferredRegister<>(ForgeRegistries.RECIPE_SERIALIZERS, Reference.id);

    public static final RegistryObject<IRecipeSerializer<?>> MELTER_RECIPES = RECIPES.register("melter", () -> new MelterRecipeSerializer(MelterRecipe::new));
    public static final RegistryObject<IRecipeSerializer<?>> OVEN_RECIPES = RECIPES.register("brickoven", () -> new BrickOvenRecipeSerializer(BrickOvenRecipe::new));
}
