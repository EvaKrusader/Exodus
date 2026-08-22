package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.level.block.BreakBlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.exodus.network.ExodusModVariables;
import net.mcreator.exodus.init.ExodusModMobEffects;

import javax.annotation.Nullable;

import java.net.URL;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@EventBusSubscriber
public class GreedLevelGoldProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BreakBlockEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double goldAmount = 0;
		double goldGoal = 0;
		double GoldLevel = 0;
		double gold_extra = 0;
		double gold_rush_multiplier = 0;
		double gold_rush_additive = 0;
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		String url = "";
		if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).isGreedy == true && blockstate.is(BlockTags.create(Identifier.parse("exodus:gold_blocks"))) == true) {
			gold_rush_multiplier = 1;
			gold_extra = 0;
			url = "https://raw.githubusercontent.com/EvaKrusader/" + "Exodus" + "/refs/heads/master/hotfixable/curio_gold_values.json";
			file = new File(System.getProperty("java.io.tmpdir"), File.separator + "curio_gold_values.json");
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
					json = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					goldAmount = json.get((BuiltInRegistries.BLOCK.getKey(blockstate.getBlock()).toString())).getAsDouble();
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.GOLDEN_HELMET) {
						gold_extra = gold_extra + json.get("helmet").getAsDouble();
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.GOLDEN_CHESTPLATE) {
						gold_extra = gold_extra + json.get("chestplate").getAsDouble();
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.GOLDEN_LEGGINGS) {
						gold_extra = gold_extra + json.get("leggings").getAsDouble();
					}
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.GOLDEN_BOOTS) {
						gold_extra = gold_extra + json.get("boots").getAsDouble();
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GOLDEN_PICKAXE) {
						gold_extra = gold_extra + json.get("pickaxe").getAsDouble();
					}
					if ((entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(ExodusModMobEffects.GOLD_RUSH)) == true) {
						gold_rush_multiplier = json.get("gold_rush_multiplier").getAsDouble();
						gold_rush_additive = json.get("gold_rush_additive").getAsDouble();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel < 5) {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.goldAmount = entity.getData(ExodusModVariables.PLAYER_VARIABLES).goldAmount + (goldAmount + gold_extra + gold_rush_additive) * gold_rush_multiplier;
				_vars.markSyncDirty();
			}
			if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).goldAmount >= entity.getData(ExodusModVariables.PLAYER_VARIABLES).goldGoal) {
				{
					ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
					_vars.goldAmount = 0;
					_vars.greedLevel = entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel + 1;
					_vars.markSyncDirty();
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
						json = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel < 5) {
							{
								ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
								_vars.goldGoal = json.get(("greedlevel" + new java.text.DecimalFormat("#").format(entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel + 1))).getAsDouble();
								_vars.markSyncDirty();
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel > 0) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(Identifier.parse("exodus:greed"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 5) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(Identifier.parse("exodus:succumb_to_your_greed_adv"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				if (blockstate.getBlock() == Blocks.GOLD_BLOCK && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.GOLDEN_HELMET
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.GOLDEN_CHESTPLATE
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.GOLDEN_LEGGINGS
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.GOLDEN_BOOTS
						&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GOLDEN_PICKAXE) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(Identifier.parse("exodus:auromania"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:greed_upgrade")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:greed_upgrade")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}