package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.net.URL;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

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
		addList = 0;
		fileName = "playtesters" + ".json";
		url = "https://raw.githubusercontent.com/EvaKrusader/" + "Exodus" + "/refs/heads/master/hotfixable/" + fileName;
		file = new File(System.getProperty("java.io.tmpdir"), File.separator + fileName);
		try {
			org.apache.commons.io.FileUtils.copyURLToFile(new URL(url), file, 1000, 1000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				jsonObject = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				for (int _i1 = 0; _i1 < (int) playtesters.size(); _i1++) {
					if (!(entity.getDisplayName().getString()).equals(playtesters.get((int) addList).getAsString())) {
						addList = addList + 1;
					} else {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal("Thank you for testing my mod! "), false);
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal("Use the Dev keybind [0] to switch gamemodes and the UI keybind [:] to turn on/off the Dev UI"), false);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}