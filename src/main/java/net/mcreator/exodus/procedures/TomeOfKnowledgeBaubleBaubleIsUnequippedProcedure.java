package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;

public class TomeOfKnowledgeBaubleBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
			_vars.playerKnowledge = false;
			_vars.markSyncDirty();
		}
	}
}