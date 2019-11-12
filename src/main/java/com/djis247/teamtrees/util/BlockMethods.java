package com.djis247.teamtrees.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.math.BlockPos;

public class BlockMethods {
	public static List<BlockPos> getSurroundingBlocks(BlockPos pos) {
		List<BlockPos> blockPos = new ArrayList<BlockPos>();
		int posX = (int)pos.getX() - 8;
		int posY = (int)pos.getY() - 3;
		int posZ = (int)pos.getZ() - 8;
		for (int i = 0; i < 5; i++) {
			posY++;
			for(int j = 0; j < 16; j++) {
				posX++;
				int lastZ = posZ;
				for(int k = 0; k < 16; k++) {
					posZ++;
					blockPos.add(new BlockPos(posX, posY, posZ));
				}
				posZ = lastZ;
			}
		}
		return blockPos;
	}
}
