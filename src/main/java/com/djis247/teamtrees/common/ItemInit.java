package com.djis247.teamtrees.common;

import java.util.ArrayList;
import java.util.List;

import com.djis247.teamtrees.common.items.SuperFertilizer;
import com.djis247.teamtrees.common.items.TreatedWax;
import com.djis247.teamtrees.util.ModSetup;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ItemInit {
	public static List<Item> items = new ArrayList<Item>();
	
	//BlockItems
	public static final Item SUPER_ACACIA_SAPLING = register(BlockInit.SUPER_ACACIA_SAPLING);
	public static final Item SUPER_BIRCH_SAPLING = register(BlockInit.SUPER_BIRCH_SAPLING);
	public static final Item SUPER_DARK_OAK_SAPLING = register(BlockInit.SUPER_DARK_OAK_SAPLING);
	public static final Item SUPER_JUNGLE_SAPLING = register(BlockInit.SUPER_JUNGLE_SAPLING);
	public static final Item SUPER_OAK_SAPLING = register(BlockInit.SUPER_OAK_SAPLING);
	public static final Item SUPER_SPRUCE_SAPLING = register(BlockInit.SUPER_SPRUCE_SAPLING);
	public static final Item ROTTEN_WOOD = register(BlockInit.ROTTEN_WOOD);
	public static final Item TREATED_ACACIA_LOG = register(BlockInit.TREATED_ACACIA_LOG);
	public static final Item TREATED_BIRCH_LOG = register(BlockInit.TREATED_BIRCH_LOG);
	public static final Item TREATED_DARK_OAK_LOG = register(BlockInit.TREATED_DARK_OAK_SAPLING);
	public static final Item TREATED_JUNGLE_LOG = register(BlockInit.TREATED_JUNGLE_LOG);
	public static final Item TREATED_OAK_LOG = register(BlockInit.TREATED_OAK_LOG);
	public static final Item TREATED_SPRUCE_LOG = register(BlockInit.TREATED_SPRUCE_LOG);
	
	//Items
	public static final Item SUPER_FERTILIZER = register("super_fertilizer", new SuperFertilizer());
	public static final Item TREATED_WAX = register("treated_wax", new TreatedWax());
	
	private static Item register(Block block) {
		BlockItem item = new BlockItem(block, new Item.Properties().group(ModSetup.MAIN_ITEM_GROUP));
		return register(block.getRegistryName().toString(), item);
	}
	private static Item register(String name, Item item) {
		item.setRegistryName(name);
		items.add(item);
		return item;
	}
}
