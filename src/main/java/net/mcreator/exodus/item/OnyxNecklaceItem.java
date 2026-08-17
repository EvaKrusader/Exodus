package net.mcreator.exodus.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import net.mcreator.exodus.procedures.CreeperRepellentRangeValueProcedure;
import net.mcreator.exodus.procedures.CreeperRepellentPropertyValueProviderProcedure;
import net.mcreator.exodus.procedures.CreeperRepellentHasItemGlowingEffectProcedure;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class OnyxNecklaceItem extends Item {
	public OnyxNecklaceItem(Item.Properties properties) {
		super(properties.durability(100));
	}

	@Override
	public boolean isFoil(ItemStack itemstack) {
		return CreeperRepellentHasItemGlowingEffectProcedure.execute();
	}

	public record HasBiolumProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<HasBiolumProperty> MAP_CODEC = MapCodec.unit(new HasBiolumProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) CreeperRepellentPropertyValueProviderProcedure.execute(owner != null ? owner.level() : clientWorld, itemStackToRender);
		}

		@Override
		public MapCodec<HasBiolumProperty> type() {
			return MAP_CODEC;
		}
	}

	public record RangeLevelProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<RangeLevelProperty> MAP_CODEC = MapCodec.unit(new RangeLevelProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) CreeperRepellentRangeValueProcedure.execute(owner != null ? owner.level() : clientWorld, itemStackToRender);
		}

		@Override
		public MapCodec<RangeLevelProperty> type() {
			return MAP_CODEC;
		}
	}
}