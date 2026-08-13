package net.mcreator.thebetterserver.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class RubyHoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6f, 0, 14, TagKey.create(Registries.ITEM, Identifier.parse("the_better_server:ruby_hoe_repair_items")));

	public RubyHoeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 0f, -1f, properties);
	}
}