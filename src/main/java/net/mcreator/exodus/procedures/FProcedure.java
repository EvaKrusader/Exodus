package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.io.File;

@EventBusSubscriber
public class FProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		String fileName = "";
		String url = "";
		File file = new File("");
		com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
		com.google.gson.JsonArray playtesters = new com.google.gson.JsonArray();
		double addList = 0;
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("Thank you for testing my mod! "), false);
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("Use the Dev keybind [0] to switch gamemodes and the UI keybind [:] to turn on/off the Dev UI"), false);
	}
}