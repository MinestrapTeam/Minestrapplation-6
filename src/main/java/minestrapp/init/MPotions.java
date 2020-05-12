package minestrapp.init;

import minestrapp.Reference;
import minestrapp.potion.PotionClimbing;
import minestrapp.potion.PotionHydrophobia;
import minestrapp.potion.PotionInfection;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MPotions {



    public static final DeferredRegister<Potion> POTION_REGISTRY = new DeferredRegister<>(ForgeRegistries.POTION_TYPES, Reference.id);
    public static final DeferredRegister<Effect> EFFECT_REGISTRY = new DeferredRegister<>(ForgeRegistries.POTIONS, Reference.id);

    //Potions
    public static final RegistryObject<Effect> HYDROPHOBIA_EFFECT = EFFECT_REGISTRY.register("hydrophobia_effect", () -> new PotionHydrophobia());
    public static final RegistryObject<Potion> HYDROPHOBIA = POTION_REGISTRY.register("hydrophobia", () -> new Potion(new EffectInstance(HYDROPHOBIA_EFFECT.get(), 1800)));
    public static final RegistryObject<Effect> CLIMBING_EFFECT = EFFECT_REGISTRY.register("climbing_effect", () -> new PotionClimbing());
    public static final RegistryObject<Potion> CLIMBING = POTION_REGISTRY.register("climbing", () -> new Potion(new EffectInstance(CLIMBING_EFFECT.get(), 3600)));
    public static final RegistryObject<Effect> INFECTION_EFFECT = EFFECT_REGISTRY.register("infection_effect", () -> new PotionInfection());
    public static final RegistryObject<Potion> INFECTION = POTION_REGISTRY.register("infection", () -> new Potion(new EffectInstance(INFECTION_EFFECT.get(), 4800)));

}
