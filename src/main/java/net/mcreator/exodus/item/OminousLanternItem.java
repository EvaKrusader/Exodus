package net.mcreator.exodus.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import net.mcreator.exodus.procedures.OminousLanternLevelProviderProcedure;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class OminousLanternItem extends Item {
	public OminousLanternItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	public record OminousLevelProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<OminousLevelProperty> MAP_CODEC = MapCodec.unit(new OminousLevelProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) OminousLanternLevelProviderProcedure.execute(owner != null ? owner.asLivingEntity() : null);
		}

		@Override
		public MapCodec<OminousLevelProperty> type() {
			return MAP_CODEC;
		}
	}
}