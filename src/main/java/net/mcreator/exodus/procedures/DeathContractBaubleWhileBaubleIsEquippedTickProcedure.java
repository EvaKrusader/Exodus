package net.mcreator.exodus.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;

public class DeathContractBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).deathContractDied == true) {
			itemstack.shrink(1);
		}
	}
}