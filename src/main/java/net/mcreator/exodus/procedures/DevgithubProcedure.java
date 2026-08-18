package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.level.block.BreakBlockEvent;
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
public class DevgithubProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BreakBlockEvent event) {
		execute(event, event.getPlayer());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject mainJOBJ = new com.google.gson.JsonObject();
		file = new File("https://github.com/EvaKrusader/Exodus/blob/master/src/main/resources/assets/exodus/values/curio_gold_values.json", File.separator + "curio_gold_values.json");
		if (file.exists() == true) {
			try {
				org.apache.commons.io.FileUtils.copyURLToFile(new URL("https://github.com/EvaKrusader/Exodus/blob/master/src/main/resources/assets/exodus/values/curio_gold_values.json"), file, 4000, 4000);
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
					mainJOBJ = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					mainJOBJ = mainJOBJ.get("day").getAsJsonObject();
					if (entity instanceof ServerPlayer _player)
						_player.sendSystemMessage(Component.literal(mainJOBJ.get("day").getAsString()), false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}