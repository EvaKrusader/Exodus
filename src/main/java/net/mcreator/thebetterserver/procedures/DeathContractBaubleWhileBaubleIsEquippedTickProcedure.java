package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

public class DeathContractBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).deathContractDied == true) {
			itemstack.shrink(1);
		}
	}
}