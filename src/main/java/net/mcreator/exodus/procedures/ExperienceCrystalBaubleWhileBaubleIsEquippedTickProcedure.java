package net.mcreator.exodus.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.exodus.network.ExodusModVariables;
import net.mcreator.exodus.ExodusMod;

public class ExperienceCrystalBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ExodusMod.queueServerWork(5, () -> {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("xp_value", 0) == 0) {
				{
					final String _tagName = "xp_value";
					final double _tagValue = entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerXPbeforeDeath;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else {
				{
					final String _tagName = "xp_value";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("xp_value", 0) + entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerXPbeforeDeath);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		});
	}
}