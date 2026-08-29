/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exodus.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.Identifier;

import net.mcreator.exodus.item.*;
import net.mcreator.exodus.ExodusMod;

import java.util.function.Function;

public class ExodusModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ExodusMod.MODID);
	public static final DeferredItem<Item> CREEPER_PATCHER;
	public static final DeferredItem<Item> ONYX;
	public static final DeferredItem<Item> ONYX_ORE;
	public static final DeferredItem<Item> ONYX_BLOCK;
	public static final DeferredItem<Item> ONYX_PICKAXE;
	public static final DeferredItem<Item> ONYX_AXE;
	public static final DeferredItem<Item> ONYX_SWORD;
	public static final DeferredItem<Item> ONYX_SHOVEL;
	public static final DeferredItem<Item> ONYX_HOE;
	public static final DeferredItem<Item> ONYX_ARMOR_HELMET;
	public static final DeferredItem<Item> ONYX_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> ONYX_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> ONYX_ARMOR_BOOTS;
	public static final DeferredItem<Item> RUBY;
	public static final DeferredItem<Item> RUBY_ORE;
	public static final DeferredItem<Item> RUBY_BLOCK;
	public static final DeferredItem<Item> RUBY_PICKAXE;
	public static final DeferredItem<Item> RUBY_AXE;
	public static final DeferredItem<Item> RUBY_SWORD;
	public static final DeferredItem<Item> RUBY_SHOVEL;
	public static final DeferredItem<Item> RUBY_HOE;
	public static final DeferredItem<Item> RUBY_ARMOR_HELMET;
	public static final DeferredItem<Item> RUBY_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> RUBY_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> RUBY_ARMOR_BOOTS;
	public static final DeferredItem<Item> EXPERIENCE_GUMMY;
	public static final DeferredItem<Item> CALIDIUM;
	public static final DeferredItem<Item> CALIDIUM_ORE;
	public static final DeferredItem<Item> CALIDIUM_BLOCK;
	public static final DeferredItem<Item> CALIDIUM_PICKAXE;
	public static final DeferredItem<Item> CALIDIUM_AXE;
	public static final DeferredItem<Item> CALIDIUM_SWORD;
	public static final DeferredItem<Item> CALIDIUM_SHOVEL;
	public static final DeferredItem<Item> CALIDIUM_HOE;
	public static final DeferredItem<Item> CALIDIUM_ARMOR_HELMET;
	public static final DeferredItem<Item> CALIDIUM_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> CALIDIUM_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> CALIDIUM_ARMOR_BOOTS;
	public static final DeferredItem<Item> SCALDING_CALIDIUM;
	public static final DeferredItem<Item> BASALT_CALIDIUM_ORE;
	public static final DeferredItem<Item> GREED_RELIC;
	public static final DeferredItem<Item> HERMES_WINGS;
	public static final DeferredItem<Item> WATER_STONE;
	public static final DeferredItem<Item> DEATH_CONTRACT;
	public static final DeferredItem<Item> OMINOUS_LANTERN;
	public static final DeferredItem<Item> CHEWING_GUM;
	public static final DeferredItem<Item> EASY_BAKE_OVEN;
	public static final DeferredItem<Item> METAL_GRATE_STAIRS;
	public static final DeferredItem<Item> METAL_GRATE_SLAB;
	public static final DeferredItem<Item> ONYX_NECKLACE;
	public static final DeferredItem<Item> TUNGSTEN_INGOT;
	public static final DeferredItem<Item> TUNGSTEN_ORE;
	public static final DeferredItem<Item> TUNGSTEN_BLOCK;
	public static final DeferredItem<Item> TUNGSTEN;
	public static final DeferredItem<Item> RAW_TUNGSTEN_BLOCK;
	public static final DeferredItem<Item> SQUALINE;
	public static final DeferredItem<Item> SQUALINE_ORE;
	public static final DeferredItem<Item> SQUALINE_BLOCK;
	public static final DeferredItem<Item> SQUALINE_ARMOR_HELMET;
	public static final DeferredItem<Item> SQUALINE_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> SQUALINE_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> SQUALINE_ARMOR_BOOTS;
	public static final DeferredItem<Item> NETHERITE_FULL_SET;
	public static final DeferredItem<Item> EXPERIENCE_BLOCK;
	public static final DeferredItem<Item> FLUORITE;
	public static final DeferredItem<Item> FLUORITE_ORE;
	public static final DeferredItem<Item> FLUORITE_BLOCK;
	public static final DeferredItem<Item> FLUORITE_NECKLACE;
	public static final DeferredItem<Item> CREEPER_PATCHER_2;
	public static final DeferredItem<Item> CHARM_OF_FIRE_RESISTANCE;
	public static final DeferredItem<Item> CHARM_OF_FALL_CANCELLATION;
	public static final DeferredItem<Item> CHARM_OF_EXPERIENCE;
	public static final DeferredItem<Item> WEIRD_ARMOR_TRIM_SMITHING_TEMPLATE;
	public static final DeferredItem<Item> DITHER_ARMOR_TRIM_SMITHING_TEMPLATE;
	public static final DeferredItem<Item> TOME_OF_KNOWLEDGE;
	public static final DeferredItem<Item> EXPERIENCE_CRYSTAL;
	public static final DeferredItem<Item> STONE_ONYX_ORE;
	public static final DeferredItem<Item> CAELITE_ORE;
	public static final DeferredItem<Item> CAELITE;
	public static final DeferredItem<Item> CRESCENT_NECKLACE;
	static {
		CREEPER_PATCHER = block(ExodusModBlocks.CREEPER_PATCHER);
		ONYX = register("onyx", OnyxItem::new);
		ONYX_ORE = block(ExodusModBlocks.ONYX_ORE);
		ONYX_BLOCK = block(ExodusModBlocks.ONYX_BLOCK);
		ONYX_PICKAXE = register("onyx_pickaxe", OnyxPickaxeItem::new);
		ONYX_AXE = register("onyx_axe", OnyxAxeItem::new);
		ONYX_SWORD = register("onyx_sword", OnyxSwordItem::new);
		ONYX_SHOVEL = register("onyx_shovel", OnyxShovelItem::new);
		ONYX_HOE = register("onyx_hoe", OnyxHoeItem::new);
		ONYX_ARMOR_HELMET = register("onyx_armor_helmet", OnyxArmorItem.Helmet::new);
		ONYX_ARMOR_CHESTPLATE = register("onyx_armor_chestplate", OnyxArmorItem.Chestplate::new);
		ONYX_ARMOR_LEGGINGS = register("onyx_armor_leggings", OnyxArmorItem.Leggings::new);
		ONYX_ARMOR_BOOTS = register("onyx_armor_boots", OnyxArmorItem.Boots::new);
		RUBY = register("ruby", RubyItem::new);
		RUBY_ORE = block(ExodusModBlocks.RUBY_ORE);
		RUBY_BLOCK = block(ExodusModBlocks.RUBY_BLOCK);
		RUBY_PICKAXE = register("ruby_pickaxe", RubyPickaxeItem::new);
		RUBY_AXE = register("ruby_axe", RubyAxeItem::new);
		RUBY_SWORD = register("ruby_sword", RubySwordItem::new);
		RUBY_SHOVEL = register("ruby_shovel", RubyShovelItem::new);
		RUBY_HOE = register("ruby_hoe", RubyHoeItem::new);
		RUBY_ARMOR_HELMET = register("ruby_armor_helmet", RubyArmorItem.Helmet::new);
		RUBY_ARMOR_CHESTPLATE = register("ruby_armor_chestplate", RubyArmorItem.Chestplate::new);
		RUBY_ARMOR_LEGGINGS = register("ruby_armor_leggings", RubyArmorItem.Leggings::new);
		RUBY_ARMOR_BOOTS = register("ruby_armor_boots", RubyArmorItem.Boots::new);
		EXPERIENCE_GUMMY = register("experience_gummy", ExperienceGummyItem::new);
		CALIDIUM = register("calidium", CalidiumItem::new);
		CALIDIUM_ORE = block(ExodusModBlocks.CALIDIUM_ORE);
		CALIDIUM_BLOCK = block(ExodusModBlocks.CALIDIUM_BLOCK);
		CALIDIUM_PICKAXE = register("calidium_pickaxe", CalidiumPickaxeItem::new);
		CALIDIUM_AXE = register("calidium_axe", CalidiumAxeItem::new);
		CALIDIUM_SWORD = register("calidium_sword", CalidiumSwordItem::new);
		CALIDIUM_SHOVEL = register("calidium_shovel", CalidiumShovelItem::new);
		CALIDIUM_HOE = register("calidium_hoe", CalidiumHoeItem::new);
		CALIDIUM_ARMOR_HELMET = register("calidium_armor_helmet", CalidiumArmorItem.Helmet::new);
		CALIDIUM_ARMOR_CHESTPLATE = register("calidium_armor_chestplate", CalidiumArmorItem.Chestplate::new);
		CALIDIUM_ARMOR_LEGGINGS = register("calidium_armor_leggings", CalidiumArmorItem.Leggings::new);
		CALIDIUM_ARMOR_BOOTS = register("calidium_armor_boots", CalidiumArmorItem.Boots::new);
		SCALDING_CALIDIUM = register("scalding_calidium", ScaldingCalidiumItem::new);
		BASALT_CALIDIUM_ORE = block(ExodusModBlocks.BASALT_CALIDIUM_ORE);
		GREED_RELIC = register("greed_relic", GreedRelicItem::new);
		HERMES_WINGS = register("hermes_wings", HermesWingsItem::new);
		WATER_STONE = register("water_stone", WaterStoneItem::new);
		DEATH_CONTRACT = register("death_contract", DeathContractItem::new);
		OMINOUS_LANTERN = register("ominous_lantern", OminousLanternItem::new);
		CHEWING_GUM = register("chewing_gum", ChewingGumItem::new);
		EASY_BAKE_OVEN = block(ExodusModBlocks.EASY_BAKE_OVEN);
		METAL_GRATE_STAIRS = block(ExodusModBlocks.METAL_GRATE_STAIRS);
		METAL_GRATE_SLAB = block(ExodusModBlocks.METAL_GRATE_SLAB);
		ONYX_NECKLACE = register("onyx_necklace", OnyxNecklaceItem::new);
		TUNGSTEN_INGOT = register("tungsten_ingot", TungstenIngotItem::new);
		TUNGSTEN_ORE = block(ExodusModBlocks.TUNGSTEN_ORE);
		TUNGSTEN_BLOCK = block(ExodusModBlocks.TUNGSTEN_BLOCK);
		TUNGSTEN = register("tungsten", TungstenItem::new);
		RAW_TUNGSTEN_BLOCK = block(ExodusModBlocks.RAW_TUNGSTEN_BLOCK);
		SQUALINE = register("squaline", SqualineItem::new);
		SQUALINE_ORE = block(ExodusModBlocks.SQUALINE_ORE);
		SQUALINE_BLOCK = block(ExodusModBlocks.SQUALINE_BLOCK);
		SQUALINE_ARMOR_HELMET = register("squaline_armor_helmet", SqualineArmorItem.Helmet::new);
		SQUALINE_ARMOR_CHESTPLATE = register("squaline_armor_chestplate", SqualineArmorItem.Chestplate::new);
		SQUALINE_ARMOR_LEGGINGS = register("squaline_armor_leggings", SqualineArmorItem.Leggings::new);
		SQUALINE_ARMOR_BOOTS = register("squaline_armor_boots", SqualineArmorItem.Boots::new);
		NETHERITE_FULL_SET = register("netherite_full_set", NetheriteFullSetItem::new);
		EXPERIENCE_BLOCK = block(ExodusModBlocks.EXPERIENCE_BLOCK);
		FLUORITE = register("fluorite", FluoriteItem::new);
		FLUORITE_ORE = block(ExodusModBlocks.FLUORITE_ORE);
		FLUORITE_BLOCK = block(ExodusModBlocks.FLUORITE_BLOCK);
		FLUORITE_NECKLACE = register("fluorite_necklace", FluoriteNecklaceItem::new);
		CREEPER_PATCHER_2 = block(ExodusModBlocks.CREEPER_PATCHER_2);
		CHARM_OF_FIRE_RESISTANCE = register("charm_of_fire_resistance", CharmOfFireResistanceItem::new);
		CHARM_OF_FALL_CANCELLATION = register("charm_of_fall_cancellation", CharmOfFallCancellationItem::new);
		CHARM_OF_EXPERIENCE = register("charm_of_experience", CharmOfExperienceItem::new);
		WEIRD_ARMOR_TRIM_SMITHING_TEMPLATE = register("weird_armor_trim_smithing_template", WeirdArmorTrimSmithingTemplateItem::new);
		DITHER_ARMOR_TRIM_SMITHING_TEMPLATE = register("dither_armor_trim_smithing_template", DitherArmorTrimSmithingTemplateItem::new);
		TOME_OF_KNOWLEDGE = register("tome_of_knowledge", TomeOfKnowledgeItem::new);
		EXPERIENCE_CRYSTAL = register("experience_crystal", ExperienceCrystalItem::new);
		STONE_ONYX_ORE = block(ExodusModBlocks.STONE_ONYX_ORE);
		CAELITE_ORE = block(ExodusModBlocks.CAELITE_ORE);
		CAELITE = register("caelite", CaeliteItem::new);
		CRESCENT_NECKLACE = register("crescent_necklace", CrescentNecklaceItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), () -> properties);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		public static void registerItemModelProperties(RegisterRangeSelectItemModelPropertyEvent event) {
			event.register(Identifier.parse("exodus:greed_relic/greed_level"), GreedRelicItem.GreedLevelProperty.MAP_CODEC);
			event.register(Identifier.parse("exodus:death_contract/is_signed"), DeathContractItem.IsSignedProperty.MAP_CODEC);
			event.register(Identifier.parse("exodus:ominous_lantern/ominous_level"), OminousLanternItem.OminousLevelProperty.MAP_CODEC);
			event.register(Identifier.parse("exodus:ominous_lantern/has_nether_coal"), OminousLanternItem.HasNetherCoalProperty.MAP_CODEC);
			event.register(Identifier.parse("exodus:onyx_necklace/has_biolum"), OnyxNecklaceItem.HasBiolumProperty.MAP_CODEC);
			event.register(Identifier.parse("exodus:onyx_necklace/range_level"), OnyxNecklaceItem.RangeLevelProperty.MAP_CODEC);
			event.register(Identifier.parse("exodus:fluorite_necklace/power"), FluoriteNecklaceItem.PowerProperty.MAP_CODEC);
			event.register(Identifier.parse("exodus:experience_crystal/xp_value"), ExperienceCrystalItem.XpValueProperty.MAP_CODEC);
		}
	}
}