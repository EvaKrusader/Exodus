package net.mcreator.exodus.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.exodus.init.ExodusModMobEffects;

public class ExperienceGummyPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ExodusModMobEffects.KNOWLEDGE, (int) (itemstack.getCount() * 7.5 * 20), 0, false, false));
			if (itemstack.getCount() >= 7) {
				if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
					AdvancementHolder _adv = _level.getServer().getAdvancements().get(Identifier.parse("exodus:adv_xp_gummy_10"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
			if (itemstack.getCount() >= 15) {
				if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
					AdvancementHolder _adv = _level.getServer().getAdvancements().get(Identifier.parse("exodus:adv_xp_gummy_64"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
			for (int _i1 = 0; _i1 < itemstack.getCount(); _i1++) {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints((int) ((entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0)
							+ (entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0) * (1 + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 40d)));
			}
			itemstack.shrink(64);
		} else {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints((int) ((entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0)
						+ (entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0) * (1 + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 40d)));
		}
	}
}