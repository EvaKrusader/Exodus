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
public class DevLoadGoldValuesProcedure {
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
		double BlockValues = 0;
		double ItemValues = 0;
		double GreedValues = 0;
		BlockValues = 0;
		ItemValues = 0;
		GreedValues = 0;
		fileName = "curio_gold_values" + ".json";
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
				if (ExodusModVariables.WorldVariables.get(world).goldVal_gold_block != jsonObject.get("minecraft:gold_block").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_gold_block = jsonObject.get("minecraft:gold_block").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					BlockValues = BlockValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_raw_gold_block != jsonObject.get("minecraft:raw_gold_block").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_raw_gold_block = jsonObject.get("minecraft:raw_gold_block").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					BlockValues = BlockValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_gold_ore != jsonObject.get("minecraft:gold_ore").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_gold_ore = jsonObject.get("minecraft:gold_ore").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					BlockValues = BlockValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_deepslate_gold_ore != jsonObject.get("minecraft:deepslate_gold_ore").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_deepslate_gold_ore = jsonObject.get("minecraft:deepslate_gold_ore").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					BlockValues = BlockValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_nether_gold_ore != jsonObject.get("minecraft:nether_gold_ore").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_nether_gold_ore = jsonObject.get("minecraft:nether_gold_ore").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					BlockValues = BlockValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_gilded_blackstone != jsonObject.get("minecraft:gilded_blackstone").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_gilded_blackstone = jsonObject.get("minecraft:gilded_blackstone").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					BlockValues = BlockValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_golden_helmet != jsonObject.get("helmet").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_golden_helmet = jsonObject.get("helmet").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					ItemValues = ItemValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_golden_chestplate != jsonObject.get("chestplate").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_golden_chestplate = jsonObject.get("chestplate").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					ItemValues = ItemValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_golden_leggings != jsonObject.get("leggings").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_golden_leggings = jsonObject.get("leggings").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					ItemValues = ItemValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_golden_boots != jsonObject.get("boots").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_golden_boots = jsonObject.get("boots").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					ItemValues = ItemValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_golden_pickaxe != jsonObject.get("pickaxe").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_golden_pickaxe = jsonObject.get("pickaxe").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					ItemValues = ItemValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_gold_rush_mult != jsonObject.get("gold_rush_multiplier").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_gold_rush_mult = jsonObject.get("gold_rush_multiplier").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					GreedValues = GreedValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_gold_rush_add != jsonObject.get("gold_rush_additive").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_gold_rush_add = jsonObject.get("gold_rush_additive").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					GreedValues = GreedValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_1 != jsonObject.get("greedlevel1").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_1 = jsonObject.get("greedlevel1").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					GreedValues = GreedValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_2 != jsonObject.get("greedlevel2").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_2 = jsonObject.get("greedlevel2").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					GreedValues = GreedValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_3 != jsonObject.get("greedlevel3").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_3 = jsonObject.get("greedlevel3").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					GreedValues = GreedValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_4 != jsonObject.get("greedlevel4").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_4 = jsonObject.get("greedlevel4").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					GreedValues = GreedValues + 1;
				}
				if (ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_5 != jsonObject.get("greedlevel5").getAsDouble()) {
					ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_5 = jsonObject.get("greedlevel5").getAsDouble();
					ExodusModVariables.WorldVariables.get(world).markSyncDirty();
					GreedValues = GreedValues + 1;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (BlockValues > 0) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((new java.text.DecimalFormat("#").format(BlockValues) + " block values updated")).withColor(0xffff00), false);
			}
		}
		if (ItemValues > 0) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((new java.text.DecimalFormat("#").format(ItemValues) + " item values updated")).withColor(0xffff00), false);
			}
		}
		if (GreedValues > 0) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((new java.text.DecimalFormat("#").format(GreedValues) + " greed values updated")).withColor(0xffff00), false);
			}
		}
	}
}