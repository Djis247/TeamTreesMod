package com.djis247.teamtrees.util;

import com.djis247.teamtrees.common.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
	public static final ItemGroup MAIN_ITEM_GROUP = new ItemGroup("teamtreesmain") {

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.SUPER_OAK_SAPLING);
		}
		
	};
	public void init() {
		
	}
}
