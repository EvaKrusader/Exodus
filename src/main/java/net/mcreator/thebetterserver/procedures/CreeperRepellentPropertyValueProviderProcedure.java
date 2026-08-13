package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class CreeperRepellentPropertyValueProviderProcedure {
	public static double execute(LevelAccessor world, ItemStack itemstack) {
		if ((itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:extra_bioluminescence")))) != 0) == true) {
			return 1;
		}
		return 0;
	}
}