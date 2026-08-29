package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.exodus.network.ExodusModVariables;

import javax.annotation.Nullable;

import java.net.URL;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@EventBusSubscriber
public class DevLoadEnchantmentValuesProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		String fileName = "";
		String url = "";
		File file = new File("");
		com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
		double VampirismChance = 0;
		double VampirismPercentage = 0;
		double NumberValues = 0;
		VampirismChance = 0;
		VampirismPercentage = 0;
		NumberValues = 0;
		fileName = "enchantment_values" + ".json";
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
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_1 != jsonObject.get("vampirism_chance_1").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_1 = jsonObject.get("vampirism_chance_1").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					VampirismChance = VampirismChance + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_2 != jsonObject.get("vampirism_chance_2").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_2 = jsonObject.get("vampirism_chance_2").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					VampirismChance = VampirismChance + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_3 != jsonObject.get("vampirism_chance_3").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_3 = jsonObject.get("vampirism_chance_3").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					VampirismChance = VampirismChance + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_4 != jsonObject.get("vampirism_chance_4").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_4 = jsonObject.get("vampirism_chance_4").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					VampirismChance = VampirismChance + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_5 != jsonObject.get("vampirism_chance_5").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_5 = jsonObject.get("vampirism_chance_5").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					VampirismChance = VampirismChance + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_1 != jsonObject.get("vampirism_percentage_1").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_1 = jsonObject.get("vampirism_percentage_1").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					VampirismPercentage = VampirismPercentage + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_2 != jsonObject.get("vampirism_percentage_2").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_2 = jsonObject.get("vampirism_percentage_2").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					VampirismPercentage = VampirismPercentage + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_3 != jsonObject.get("vampirism_percentage_3").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_3 = jsonObject.get("vampirism_percentage_3").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					VampirismPercentage = VampirismPercentage + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_4 != jsonObject.get("vampirism_percentage_4").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_4 = jsonObject.get("vampirism_percentage_4").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					VampirismPercentage = VampirismPercentage + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_5 != jsonObject.get("vampirism_percentage_5").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_5 = jsonObject.get("vampirism_percentage_5").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					VampirismPercentage = VampirismPercentage + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_trial_breaker_damage != jsonObject.get("trial_breaker_damage").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_trial_breaker_damage = jsonObject.get("trial_breaker_damage").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					NumberValues = NumberValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_fluorite_necklace_cooldown != jsonObject.get("fluorite_necklace_base_cooldown").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_fluorite_necklace_cooldown = jsonObject.get("fluorite_necklace_base_cooldown").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					NumberValues = NumberValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).EnchVal_fluorite_necklace_reduction != jsonObject.get("fluorite_necklace_reduc_per_level").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).EnchVal_fluorite_necklace_reduction = jsonObject.get("fluorite_necklace_reduc_per_level").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					NumberValues = NumberValues + 1;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (VampirismChance > 0) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((new java.text.DecimalFormat("#").format(VampirismChance) + " vampirism chance values updated")).withColor(0xff00ff), false);
			}
		}
		if (VampirismPercentage > 0) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((new java.text.DecimalFormat("#").format(VampirismPercentage) + " vampirism percentage values updated")).withColor(0xff00ff), false);
			}
		}
		if (NumberValues > 0) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((new java.text.DecimalFormat("#").format(NumberValues) + " number values updated")).withColor(0xff00ff), false);
			}
		}
	}
}