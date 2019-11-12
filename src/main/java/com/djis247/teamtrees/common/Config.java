package com.djis247.teamtrees.common;

import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
	public static String CATEGORY_GENERAL = "general";
	public static String CATEGORY_RANDOM_TICKS = "randomTicks";
	public static String CLIENT_CATEGORY = "clientSettings";
	
	public static ForgeConfigSpec.IntValue PLAYER_CHANCE_TICKS;
	public static ForgeConfigSpec.IntValue BLOCK_CHANCE_TICKS;
	public static ForgeConfigSpec.IntValue SAPLING_ROT_TICKS;
	
	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;
	
	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
	
	static {
		COMMON_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);
		
		COMMON_BUILDER.comment("Random Ticks").push(CATEGORY_RANDOM_TICKS);
		
		PLAYER_CHANCE_TICKS = COMMON_BUILDER.comment("The amount of ticks for a chance for the player to infect nearby blocks with Rotten Wood. (e.g. 100 == 1 / 100 ticks == 1%)").defineInRange("playerChanceTicks", 100, 0, Integer.MAX_VALUE);
		BLOCK_CHANCE_TICKS = COMMON_BUILDER.comment("The amount of ticks for a chance for block to be rotten. Sub-chance of playerTickChance. (e.g. 10 == 1 / 10 ticks == 10%)").defineInRange("blockChanceTicks", 10, 0, Integer.MAX_VALUE);
		SAPLING_ROT_TICKS = COMMON_BUILDER.comment("The amount of ticks for a chance of sapling growth would turn into Rotten Wood. (e.g. 4 == 1 / 4 ticks == 25%)").defineInRange("saplingChanceTicks", 4, 0, Integer.MAX_VALUE);
		
		COMMON_BUILDER.pop();
		COMMON_BUILDER.pop();
		
		COMMON_CONFIG = COMMON_BUILDER.build();
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
	
	public static void loadConfig(ForgeConfigSpec spec, Path path) {
		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
		
		configData.load();
		spec.setConfig(configData);
	}
}
