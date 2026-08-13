package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.thebetterserver.init.TheBetterServerModMobEffects;

public class PhasingEffectStartedappliedProcedure {
	public static void execute(double x, double z, Entity entity) {
		if (entity == null)
			return;
		double chance = 0;
		chance = Math.random();
		if (entity instanceof Player == true) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SPECTATOR);
		} else {
			if (chance >= 0.95) {
				{
					Entity _ent = entity;
					double _tx = x;
					double _ty = (-256);
					double _tz = z;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheBetterServerModMobEffects.PHASING) ? _livEnt.getEffect(TheBetterServerModMobEffects.PHASING).getDuration() : 0, 0, false, false));
			}
		}
	}
}