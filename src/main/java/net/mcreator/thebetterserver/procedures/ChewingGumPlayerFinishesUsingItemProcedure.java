package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

public class ChewingGumPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
			_vars.isChewingGum = true;
			_vars.markSyncDirty();
		}
	}
}