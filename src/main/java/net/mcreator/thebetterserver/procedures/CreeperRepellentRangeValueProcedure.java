package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class CreeperRepellentRangeValueProcedure {
	public static double execute(LevelAccessor world, ItemStack itemstack) {
		if ((itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:mystical_conductivity")))) != 0) == true) {
			return itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:mystical_conductivity"))));
		}
		return 0;
	}
}