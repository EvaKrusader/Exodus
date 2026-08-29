package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;

public class DevOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(ExodusModVariables.PLAYER_VARIABLES).showDevUI;
	}
}