package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;
import net.mcreator.thebetterserver.TheBetterServerMod;

public class AdrenalineEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TheBetterServerMod.queueServerWork(5, () -> {
			{
				Entity _ent = entity;
				if (_ent.level() instanceof ServerLevel _serverLevel) {
					_ent.hurtServer(_serverLevel, new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.parse("the_better_server:adrenaline_damage")))),
							(float) entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).adrenalineDamage);
				}
			}
		});
	}
}