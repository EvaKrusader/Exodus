package net.mcreator.exodus.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import net.mcreator.exodus.procedures.DeathContractItemInInventoryTickProcedure;
import net.mcreator.exodus.procedures.DeathContractIsSignedTextureProcedure;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class DeathContractItem extends Item {
	public DeathContractItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		DeathContractItemInInventoryTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), itemstack);
	}

	public record IsSignedProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<IsSignedProperty> MAP_CODEC = MapCodec.unit(new IsSignedProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) DeathContractIsSignedTextureProcedure.execute(itemStackToRender);
		}

		@Override
		public MapCodec<IsSignedProperty> type() {
			return MAP_CODEC;
		}
	}
}