package net.mcreator.exodus.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class ExperienceCrystalPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("xp_value", 0) > 0) {
			return 1;
		}
		return 0;
	}
}