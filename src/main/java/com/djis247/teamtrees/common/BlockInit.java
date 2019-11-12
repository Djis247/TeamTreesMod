package com.djis247.teamtrees.common;

import java.util.ArrayList;
import java.util.List;

import com.djis247.teamtrees.common.blocks.RottenWoodBlock;
import com.djis247.teamtrees.common.blocks.SuperSaplingBlock;
import com.djis247.teamtrees.common.blocks.TreatedWoodBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.AcaciaTree;
import net.minecraft.block.trees.BirchTree;
import net.minecraft.block.trees.DarkOakTree;
import net.minecraft.block.trees.JungleTree;
import net.minecraft.block.trees.OakTree;
import net.minecraft.block.trees.SpruceTree;

public class BlockInit {
	public static List<Block> blocks = new ArrayList<Block>();
	
	//Blocks
	public static final Block SUPER_ACACIA_SAPLING = register("super_acacia_sapling", new SuperSaplingBlock(new AcaciaTree()));
	public static final Block SUPER_BIRCH_SAPLING = register("super_birch_sapling", new SuperSaplingBlock(new BirchTree()));
	public static final Block SUPER_DARK_OAK_SAPLING = register("super_dark_oak_sapling", new SuperSaplingBlock(new DarkOakTree()));
	public static final Block SUPER_JUNGLE_SAPLING = register("super_jungle_sapling", new SuperSaplingBlock(new JungleTree()));
	public static final Block SUPER_OAK_SAPLING = register("super_oak_sapling", new SuperSaplingBlock(new OakTree()));
	public static final Block SUPER_SPRUCE_SAPLING = register("super_spruce_sapling", new SuperSaplingBlock(new SpruceTree()));
	public static final Block ROTTEN_WOOD = register("rotten_wood", new RottenWoodBlock());
	public static final Block TREATED_ACACIA_LOG = register("treated_acacia_log", new TreatedWoodBlock(Blocks.ACACIA_LOG));
	public static final Block TREATED_BIRCH_LOG = register("treated_birch_log", new TreatedWoodBlock(Blocks.BIRCH_LOG));
	public static final Block TREATED_DARK_OAK_SAPLING = register("treated_dark_oak_log", new TreatedWoodBlock(Blocks.DARK_OAK_LOG));
	public static final Block TREATED_JUNGLE_LOG = register("treated_jungle_log", new TreatedWoodBlock(Blocks.JUNGLE_LOG));
	public static final Block TREATED_OAK_LOG = register("treated_oak_log", new TreatedWoodBlock(Blocks.OAK_LOG));
	public static final Block TREATED_SPRUCE_LOG = register("treated_spruce_log", new TreatedWoodBlock(Blocks.SPRUCE_LOG));
	
	private static Block register(String name, Block block) {
		block.setRegistryName(name);
		blocks.add(block);
		return block;
	}
}
