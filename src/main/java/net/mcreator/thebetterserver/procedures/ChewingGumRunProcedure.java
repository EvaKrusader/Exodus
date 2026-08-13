package net.mcreator.thebetterserver.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ChewingGumRunProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double runChance = 0;
		if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).isChewingGum == true) {
			if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).chewingGumLevel == 0) {
				runChance = 0.5;
			} else if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).chewingGumLevel == 1) {
				runChance = 0.6;
			} else if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).chewingGumLevel == 2) {
				runChance = 0.7;
			} else if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).chewingGumLevel == 3) {
				runChance = 0.8;
			} else if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).chewingGumLevel == 4) {
				runChance = 0.9;
			} else if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).chewingGumLevel == 5) {
				runChance = 0.98;
			}
			if (entity.isSprinting() == true) {
				if (Math.random() > runChance) {
					{
						Entity _ent = entity;
						if (_ent.level() instanceof ServerLevel _serverLevel) {
							_ent.hurtServer(_serverLevel, new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.parse("the_better_server:choking")))), 1);
						}
					}
					{
						TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
						_vars.chewingGumCounter = 0;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}