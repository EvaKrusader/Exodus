package net.mcreator.exodus.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.registries.Registries;

import net.mcreator.exodus.ExodusMod;

public class NetheriteFullSetPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double slot = 0;
		ItemStack item = ItemStack.EMPTY;
		slot = 3;
		for (int _i1 = 0; _i1 < 4; _i1++) {
			if (slot == 3) {
				item = new ItemStack(Items.NETHERITE_HELMET).copy();
			} else if (slot == 2) {
				item = new ItemStack(Items.NETHERITE_CHESTPLATE).copy();
			} else if (slot == 1) {
				item = new ItemStack(Items.NETHERITE_LEGGINGS).copy();
			} else {
				item = new ItemStack(Items.NETHERITE_BOOTS).copy();
			}
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(new Object() {
					public static EquipmentSlot armorSlotByIndex(int _slotindex) {
						for (EquipmentSlot _slot : EquipmentSlot.values()) {
							if (_slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR && _slot.getIndex() == _slotindex) {
								return _slot;
							}
						}
						throw new IllegalArgumentException("Invalid slot index: " + _slotindex);
					}
				}.armorSlotByIndex((int) slot), item);
			}
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(new Object() {
				public static EquipmentSlot armorSlotByIndex(int _slotindex) {
					for (EquipmentSlot _slot : EquipmentSlot.values()) {
						if (_slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR && _slot.getIndex() == _slotindex) {
							return _slot;
						}
					}
					throw new IllegalArgumentException("Invalid slot index: " + _slotindex);
				}
			}.armorSlotByIndex((int) slot)) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION), 4);
			slot = slot - 1;
		}
		ExodusMod.queueServerWork(1, () -> {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack3 = new ItemStack(Items.NETHERITE_SWORD).copy();
				_setstack3.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack3);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		});
	}
}