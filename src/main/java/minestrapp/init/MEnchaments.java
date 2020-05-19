package minestrapp.init;

import minestrapp.Reference;
import minestrapp.enchantments.EnchantExcavating;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MEnchaments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, Reference.id);
    public static final RegistryObject<Enchantment> EXCAVATING = ENCHANTMENTS.register("excavating", () -> new EnchantExcavating());
}
