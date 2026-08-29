package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class XpCrystalRespawnProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
			_vars.playerXPbeforeDeath = 0;
			_vars.markSyncDirty();
		}
	}
}