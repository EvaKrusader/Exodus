package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;

public class OminousLanternLevelProviderProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getData(ExodusModVariables.PLAYER_VARIABLES).latest_trial_level;
	}
}