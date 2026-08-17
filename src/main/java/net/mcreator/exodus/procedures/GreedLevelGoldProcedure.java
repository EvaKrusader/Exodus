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
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.exodus.network.ExodusModVariables;
import net.mcreator.exodus.init.ExodusModMobEffects;

import javax.annotation.Nullable;

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
		if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 0) {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.goldGoal = 20;
				_vars.markSyncDirty();
			}
		} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 1) {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.goldGoal = 50;
				_vars.markSyncDirty();
			}
		} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 2) {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.goldGoal = 100;
				_vars.markSyncDirty();
			}
		} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 3) {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.goldGoal = 150;
				_vars.markSyncDirty();
			}
		} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel == 4) {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.goldGoal = 200;
				_vars.markSyncDirty();
			}
		}
		if (blockstate.is(BlockTags.create(Identifier.parse("exodus:gold_blocks"))) == true) {
			gold_rush_multiplier = 1;
			gold_extra = 0;
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.GOLDEN_HELMET) {
				gold_extra = gold_extra + 0.09;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.GOLDEN_CHESTPLATE) {
				gold_extra = gold_extra + 0.11;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.GOLDEN_LEGGINGS) {
				gold_extra = gold_extra + 0.075;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.GOLDEN_BOOTS) {
				gold_extra = gold_extra + 0.065;
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GOLDEN_PICKAXE) {
				gold_extra = gold_extra + 0.09;
			}
			if ((entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(ExodusModMobEffects.GOLD_RUSH)) == true) {
				gold_rush_multiplier = 1.3;
				gold_rush_additive = 0.5;
			}
			if (blockstate.getBlock() == Blocks.GOLD_ORE) {
				goldAmount = 0.04;
			}
			if (blockstate.getBlock() == Blocks.DEEPSLATE_GOLD_ORE) {
				goldAmount = 0.07;
			}
			if (blockstate.getBlock() == Blocks.NETHER_GOLD_ORE) {
				goldAmount = 0.055;
			}
			if (blockstate.getBlock() == Blocks.GOLD_BLOCK) {
				goldAmount = 0.3;
			}
			if (blockstate.getBlock() == Blocks.RAW_GOLD_BLOCK) {
				goldAmount = 0.17;
			}
			if (blockstate.getBlock() == Blocks.GILDED_BLACKSTONE) {
				goldAmount = 0.045;
			}
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