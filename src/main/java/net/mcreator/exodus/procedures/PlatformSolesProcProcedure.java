package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

import java.io.File;

@EventBusSubscriber
public class PlatformSolesProcProcedure {
	@SubscribeEvent
	public static void whenEntityChangeEquipment(LivingEquipmentChangeEvent event) {
		execute(event, event.getEntity().level(), event.getEntity(), event.getTo());
	}

	public static void execute(LevelAccessor world, Entity entity, ItemStack newitemstack) {
		execute(null, world, entity, newitemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ItemStack newitemstack) {
		if (entity == null)
			return;
		String fileName = "";
		String url = "";
		File file = new File("");
		com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
		if (newitemstack.is(ItemTags.create(Identifier.parse("minecraft:foot_armor")))) {
			if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:platform_soles")))) != 0) == true) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(Identifier.parse("exodus:platform_soles"),
							((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.STEP_HEIGHT) ? _livingEntity3.getAttribute(Attributes.STEP_HEIGHT).getBaseValue() : 0)
									+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:platform_soles")))) / 3.5),
							AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.STEP_HEIGHT).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.STEP_HEIGHT).addTransientModifier(modifier);
					}
				}
				if ((entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.STEP_HEIGHT)
						? _livingEntity7.getAttribute(Attributes.STEP_HEIGHT).getValue()
						: 0) != (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.STEP_HEIGHT) ? _livingEntity8.getAttribute(Attributes.STEP_HEIGHT).getBaseValue() : 0)
								+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:platform_soles")))) / 3.5) {
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.STEP_HEIGHT).removeModifier(Identifier.parse("exodus:platform_soles"));
					}
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(Identifier.parse("exodus:platform_soles"),
								((entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.STEP_HEIGHT) ? _livingEntity12.getAttribute(Attributes.STEP_HEIGHT).getBaseValue() : 0)
										+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
												.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:platform_soles")))) / 3.5),
								AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.STEP_HEIGHT).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.STEP_HEIGHT).addTransientModifier(modifier);
						}
					}
				}
			} else {
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.STEP_HEIGHT).removeModifier(Identifier.parse("exodus:platform_soles"));
				}
			}
		}
	}
}