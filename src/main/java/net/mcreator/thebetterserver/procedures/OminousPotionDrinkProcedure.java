package net.mcreator.thebetterserver.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OminousPotionDrinkProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == Items.OMINOUS_BOTTLE) {
			{
				TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
				_vars.latest_trial_level = (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BAD_OMEN) ? _livEnt.getEffect(MobEffects.BAD_OMEN).getAmplifier() : 0) + 1;
				_vars.markSyncDirty();
			}
		}
	}
}