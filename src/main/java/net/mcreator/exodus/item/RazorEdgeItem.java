package net.mcreator.exodus.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.exodus.procedures.RazorEdgeLivingEntityIsHitWithToolProcedure;
import net.mcreator.exodus.init.ExodusModItems;

@EventBusSubscriber
public class RazorEdgeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 0, 4f, 0, 2, TagKey.create(Registries.ITEM, Identifier.parse("exodus:razor_edge_repair_items")));

	public RazorEdgeItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 0f, 0f));
	}

	@SubscribeEvent
	public static void modifyDefaultComponents(ModifyDefaultComponentsEvent event) {
		event.modify(ExodusModItems.RAZOR_EDGE.get(), (builder, _, _) -> builder.set(DataComponents.MAX_DAMAGE, null));
	}

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		super.hurtEnemy(itemstack, entity, sourceentity);
		RazorEdgeLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity, sourceentity);
	}
}