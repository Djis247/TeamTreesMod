package com.djis247.teamtrees.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;

public class TreatedWoodBlock extends Block {

	public TreatedWoodBlock(Block blockIn) {
		super(Block.Properties.from(blockIn).hardnessAndResistance(.5F));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(BlockStateProperties.AXIS);
	}
	
	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state != null) {
			state = state.with(BlockStateProperties.AXIS, context.getNearestLookingDirection().getAxis());
		}
		return state;
	}
}
