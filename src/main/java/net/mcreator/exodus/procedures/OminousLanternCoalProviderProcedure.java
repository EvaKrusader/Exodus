package net.mcreator.exodus.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class OminousLanternCoalProviderProcedure {
	public static double execute(LevelAccessor world, ItemStack itemstack) {
		if ((itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:nether_coal")))) != 0) == true) {
			return 1;
		}
		return 0;
	}
}