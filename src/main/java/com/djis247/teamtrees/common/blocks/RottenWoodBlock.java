package com.djis247.teamtrees.common.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.djis247.teamtrees.common.BlockInit;
import com.djis247.teamtrees.util.BlockMethods;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RottenWoodBlock extends Block {
	public RottenWoodBlock() {
		super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2F).tickRandomly().sound(SoundType.WOOD));
	}
	
	/*@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		if (placer != null) {
			worldIn.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, placer)));
		}
	}
	
	public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
		return Direction.getFacingFromVector((float)(entity.posX - clickedBlock.getX()), (float)(entity.posY - clickedBlock.getY()), (float)(entity.posZ - clickedBlock.getZ()));
	}*/
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(BlockStateProperties.FACING);
	}
	
	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state != null) {
			state = state.with(BlockStateProperties.FACING, context.getNearestLookingDirection());
		}
		return state;
	}
	
	@Override
	public boolean ticksRandomly(BlockState state) {
		return true;
	}
	
	@Override
	public void randomTick(BlockState state, World worldIn, BlockPos posIn, Random random) {
		this.tick(state, worldIn, posIn, random);
	}
	
	@Override
	public void tick(BlockState state, World worldIn, BlockPos posIn, Random random) {
		Random rand = worldIn.getRandom();
		if (rand.nextInt(10) == 0) { worldIn.setBlockState(posIn, Blocks.AIR.getDefaultState()); }
		List<BlockPos> blockPos = BlockMethods.getSurroundingBlocks(posIn);
		for (BlockPos pos : blockPos) {
			if (worldIn.getBlockState(pos).getBlock() instanceof LogBlock) {
				worldIn.setBlockState(pos, BlockInit.ROTTEN_WOOD.getDefaultState());
			}
		}
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (!worldIn.isRemote && worldIn.rand.nextInt(10) == 0) {
			worldIn.destroyBlock(pos, true);
		}
	}
}
