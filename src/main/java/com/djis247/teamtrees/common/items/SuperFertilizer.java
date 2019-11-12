package com.djis247.teamtrees.common.items;

import java.util.List;
import java.util.Random;

import com.djis247.teamtrees.util.BlockMethods;
import com.djis247.teamtrees.util.ModSetup;

import net.minecraft.block.IGrowable;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SuperFertilizer extends Item {
	public SuperFertilizer() {
		super(new Item.Properties().group(ModSetup.MAIN_ITEM_GROUP));
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		growArea(context.getWorld(), context.getPlayer(), context.getHand());
		return ActionResultType.SUCCESS;
	}
	
	private void growArea(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if(!playerIn.isCreative()) {
			itemstack.setCount(itemstack.getCount() - 1);
		}
		List<BlockPos> blocks = BlockMethods.getSurroundingBlocks(playerIn.getPosition());
		for (BlockPos blockPos : blocks) {
			if (worldIn.getBlockState(blockPos).getBlock() instanceof IGrowable) {
				IGrowable growable = (IGrowable)worldIn.getBlockState(blockPos).getBlock();
				Random rand = worldIn.getRandom();
				growable.grow(worldIn, rand, blockPos, worldIn.getBlockState(blockPos));
				if (worldIn.isRemote) {
					for(int i = 0; i < 5; i++) {
						Minecraft.getInstance().world.addParticle(ParticleTypes.HAPPY_VILLAGER, blockPos.getX() + rand.nextDouble(), blockPos.getY() + rand.nextDouble(), blockPos.getZ() + rand.nextDouble(), 0D, 10D, 0D);
					}
				}
			}
		}
	}
}
