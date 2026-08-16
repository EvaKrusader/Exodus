package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.exodus.network.ExodusModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ChewingGumTakeDamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getOriginalDamage());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		execute(null, world, x, y, z, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		double damageChance = 0;
		if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).isChewingGum == true) {
			if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).chewingGumLevel == 0) {
				damageChance = 0.7;
			} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).chewingGumLevel == 1) {
				damageChance = 0.6;
			} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).chewingGumLevel == 2) {
				damageChance = 0.45;
			} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).chewingGumLevel == 3) {
				damageChance = 0.35;
			} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).chewingGumLevel == 4) {
				damageChance = 0.25;
			} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).chewingGumLevel == 5) {
				damageChance = 0.15;
			}
			if (Math.random() < 0.5 * (amount / 10 + 1)) {
				{
					ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
					_vars.isChewingGum = false;
					_vars.markSyncDirty();
				}
				{
					Entity _ent = entity;
					if (_ent.level() instanceof ServerLevel _serverLevel) {
						_ent.hurtServer(_serverLevel, new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.parse("exodus:choking")))), 1);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:choke_cough")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:choke_cough")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
					_vars.chewingGumCounter = 0;
					_vars.markSyncDirty();
				}
			}
		}
	}
}