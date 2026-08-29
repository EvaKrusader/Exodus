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

import java.io.File;

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
			goldAmount = 0;
			gold_rush_multiplier = 1;
			gold_rush_additive = 0;
			gold_extra = 0;
			if (blockstate.getBlock() == Blocks.GOLD_BLOCK) {
				goldAmount = ExodusModVariables.WorldVariables.get(world).goldVal_gold_block;
			} else if (blockstate.getBlock() == Blocks.RAW_GOLD_BLOCK) {
				goldAmount = ExodusModVariables.WorldVariables.get(world).goldVal_raw_gold_block;
			} else if (blockstate.getBlock() == Blocks.GOLD_ORE) {
				goldAmount = ExodusModVariables.WorldVariables.get(world).goldVal_gold_ore;
			} else if (blockstate.getBlock() == Blocks.DEEPSLATE_GOLD_ORE) {
				goldAmount = ExodusModVariables.WorldVariables.get(world).goldVal_deepslate_gold_ore;
			} else if (blockstate.getBlock() == Blocks.NETHER_GOLD_ORE) {
				goldAmount = ExodusModVariables.WorldVariables.get(world).goldVal_nether_gold_ore;
			} else if (blockstate.getBlock() == Blocks.GILDED_BLACKSTONE) {
				goldAmount = ExodusModVariables.WorldVariables.get(world).goldVal_gilded_blackstone;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.GOLDEN_HELMET) {
				gold_extra = gold_extra + ExodusModVariables.WorldVariables.get(world).goldVal_golden_helmet;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.GOLDEN_CHESTPLATE) {
				gold_extra = gold_extra + ExodusModVariables.WorldVariables.get(world).goldVal_golden_chestplate;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.GOLDEN_LEGGINGS) {
				gold_extra = gold_extra + ExodusModVariables.WorldVariables.get(world).goldVal_golden_leggings;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.GOLDEN_BOOTS) {
				gold_extra = gold_extra + ExodusModVariables.WorldVariables.get(world).goldVal_golden_boots;
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GOLDEN_PICKAXE) {
				gold_extra = gold_extra + ExodusModVariables.WorldVariables.get(world).goldVal_golden_pickaxe;
			}
			if ((entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(ExodusModMobEffects.GOLD_RUSH)) == true) {
				gold_rush_multiplier = ExodusModVariables.WorldVariables.get(world).goldVal_gold_rush_mult;
				gold_rush_additive = ExodusModVariables.WorldVariables.get(world).goldVal_gold_rush_add;
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
				if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 0) {
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.goldGoal = ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_1;
						_vars.markSyncDirty();
					}
				} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 1) {
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.goldGoal = ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_2;
						_vars.markSyncDirty();
					}
				} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 2) {
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.goldGoal = ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_3;
						_vars.markSyncDirty();
					}
				} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 3) {
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.goldGoal = ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_4;
						_vars.markSyncDirty();
					}
				} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 4) {
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.goldGoal = ExodusModVariables.WorldVariables.get(world).goldVal_greed_lvl_5;
						_vars.markSyncDirty();
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