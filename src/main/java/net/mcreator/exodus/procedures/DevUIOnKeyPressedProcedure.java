package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;

public class DevUIOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).showDevUI == true) {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.showDevUI = false;
				_vars.markSyncDirty();
			}
		} else {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.showDevUI = true;
				_vars.markSyncDirty();
			}
		}
	}
}