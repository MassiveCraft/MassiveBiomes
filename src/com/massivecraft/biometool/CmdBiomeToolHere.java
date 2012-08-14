package com.massivecraft.biometool;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.WorldServer;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.CraftWorld;

import com.massivecraft.mcore4.cmd.req.ReqHasPerm;
import com.massivecraft.mcore4.cmd.req.ReqIsPlayer;

public class CmdBiomeToolHere extends BiomeToolCommand
{
	public CmdBiomeToolHere()
	{
		super();
		this.addAliases("here");
		this.addRequirements(new ReqHasPerm(Permission.HERE.node));
		this.addRequirements(ReqIsPlayer.getInstance());
	}
	
	@Override
	public void perform()
	{
		Location loc = me.getLocation();
		int blockX = loc.getBlockX();
		int blockZ = loc.getBlockZ();
		
		World world = loc.getWorld();
		CraftWorld craftWorld = (CraftWorld)world;
		WorldServer worldServer = craftWorld.getHandle();
		
		BiomeBase biomeBase = worldServer.getBiome(blockX, blockZ);
		String biomeBaseName = biomeBase.y;
		Integer biomeBaseId = biomeBase.id;
		
		msg("<i>Biome here is <k>id <v>%s<i> and <k>Name <v>%s<i>.", biomeBaseId.toString(), biomeBaseName);
	}
}