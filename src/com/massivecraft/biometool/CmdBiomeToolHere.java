package com.massivecraft.biometool;

import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.World;

import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.cmd.req.ReqIsPlayer;
import com.massivecraft.mcore.util.BiomeUtil;

public class CmdBiomeToolHere extends BiomeToolCommand
{
	public CmdBiomeToolHere()
	{
		super();
		this.addAliases("here");
		this.addRequirements(new ReqHasPerm(Permission.HERE.node));
		this.addRequirements(ReqIsPlayer.get());
	}
	
	@Override
	public void perform()
	{
		Location loc = me.getLocation();
				
		World world = loc.getWorld();
		int x = loc.getBlockX();
		int z = loc.getBlockZ();
		
		Entry<Integer, String> idAndName = BiomeUtil.getBiomeIdAndNameAt(world, x, z);
		Integer id = idAndName.getKey();
		String name = idAndName.getValue();
		
		msg("<i>Biome here is <k>id <v>%s<i> and <k>Name <v>%s<i>.", id.toString(), name);
	}
}