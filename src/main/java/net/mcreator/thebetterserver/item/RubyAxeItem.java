package net.mcreator.thebetterserver.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class RubyAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6f, 0, 14, TagKey.create(Registries.ITEM, Identifier.parse("the_better_server:ruby_axe_repair_items")));

	public RubyAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 8f, -3f, properties);
	}
}