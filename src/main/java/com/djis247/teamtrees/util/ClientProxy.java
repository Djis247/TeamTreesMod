package com.djis247.teamtrees.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
