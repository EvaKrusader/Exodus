package net.mcreator.exodus.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import net.mcreator.exodus.procedures.CreeperRepellentRangeValueProcedure;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class FluoriteNecklaceItem extends Item {
	public FluoriteNecklaceItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	public record PowerProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<PowerProperty> MAP_CODEC = MapCodec.unit(new PowerProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) CreeperRepellentRangeValueProcedure.execute(owner != null ? owner.level() : clientWorld, itemStackToRender);
		}

		@Override
		public MapCodec<PowerProperty> type() {
			return MAP_CODEC;
		}
	}
}