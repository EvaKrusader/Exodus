package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.level.block.BreakBlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.exodus.network.ExodusModVariables;
import net.mcreator.exodus.init.ExodusModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GildedBlackstoneGreedProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BreakBlockEvent event) {
		execute(event, event.getState(), event.getPlayer());
	}

	public static void execute(BlockState blockstate, Entity entity) {
		execute(null, blockstate, entity);
	}

	private static void execute(@Nullable Event event, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double power = 0;
		double durationSeconds = 0;
		double startChance = 0;
		if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel != 0) {
			startChance = entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel * 0.19;
			durationSeconds = entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel * 7.4 + 3.6;
			power = entity.getData(ExodusModVariables.PLAYER_VARIABLES).greedLevel * 0.65 + 0;
		}
		if (blockstate.getBlock() == Blocks.GILDED_BLACKSTONE && startChance >= Math.random()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ExodusModMobEffects.GOLD_RUSH, (int) (durationSeconds * 20), (int) power, false, false));
		}
	}
}