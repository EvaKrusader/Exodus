package net.mcreator.thebetterserver.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import net.mcreator.thebetterserver.procedures.PhasingEffectStartedappliedProcedure;
import net.mcreator.thebetterserver.init.TheBetterServerModMobEffects;

@EventBusSubscriber
public class PhasingMobEffect extends MobEffect {
	public PhasingMobEffect() {
		super(MobEffectCategory.NEUTRAL, -8519811);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		PhasingEffectStartedappliedProcedure.execute(entity.getX(), entity.getZ(), entity);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, AbstractContainerScreen<?> screen, GuiGraphicsExtractor guiGraphics, int x, int y, int blitOffset) {
				return false;
			}

			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, TheBetterServerModMobEffects.PHASING.get());
	}
}