package com.djis247.teamtrees.util;

import java.util.List;
import java.util.Random;

import com.djis247.teamtrees.common.BlockInit;
import com.djis247.teamtrees.common.Config;
import com.djis247.teamtrees.common.blocks.SuperSaplingBlock;

import net.minecraft.block.LogBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {

    @SubscribeEvent
    public static void saplingGrowEvent(SaplingGrowTreeEvent event) {
    	Random rand = event.getWorld().getRandom();
    	if (rand.nextInt(4) == 0 && !(event.getWorld().getBlockState(event.getPos()).getBlock() instanceof SuperSaplingBlock)) {
    		event.getWorld().setBlockState(event.getPos(), BlockInit.ROTTEN_WOOD.getDefaultState(), 3);
    	}
    }
    @SubscribeEvent
    public static void playerTick(PlayerTickEvent event) {
    	if (event.side.isServer()) {
    		Random rand = event.player.world.rand;
    		if (rand.nextInt(Config.PLAYER_CHANCE_TICKS.get()) == 0) {
    			List<BlockPos> positions = BlockMethods.getSurroundingBlocks(event.player.getPosition());
    			for (BlockPos pos : positions) {
    				if (event.player.world.getBlockState(pos).getBlock() instanceof LogBlock && rand.nextInt(Config.BLOCK_CHANCE_TICKS.get()) == 0) {
    					event.player.world.setBlockState(pos, BlockInit.ROTTEN_WOOD.getDefaultState());
    				}
    			}
    		}
    	}
    }
}
