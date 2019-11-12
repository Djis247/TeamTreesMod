package com.djis247.teamtrees.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SuperSaplingBlock extends SaplingBlock {
	
	public SuperSaplingBlock(Tree tree) {
		super(tree, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0F).sound(SoundType.PLANT));
	}
	
	@Override
	public void tick(BlockState state, World worldIn, BlockPos pos, Random rand) {
		if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if (worldIn.getLight(pos.up()) >= 9) {
			this.grow(worldIn, rand, pos, state);
		}
	}
	
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		for(int i = 0; i < 5; i++) {
			double posX = pos.getX();
			double posZ = pos.getZ();
			switch(rand.nextInt(4)) {
				case 0:
					posX += rand.nextDouble();
					posZ += rand.nextDouble();
					break;
				case 1:
					posX += rand.nextDouble();
					//posZ -= rand.nextDouble();
					break;
				case 2:
					//posX -= rand.nextDouble();
					posZ += rand.nextDouble();
					break;
				case 3:
				default:
					//posX -= rand.nextDouble();
					//posZ -= rand.nextDouble();
					break;
			}
			worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, posX, pos.getY() + 0.5D, posZ, 0.0D, 10.0D, 0.0D);
		}
	}
}
