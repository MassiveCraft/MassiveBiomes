package com.massivecraft.biometool;

import org.bukkit.World;
import org.bukkit.craftbukkit.CraftWorld;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.WorldServer;

import com.massivecraft.mcore4.cmd.arg.ARInteger;
import com.massivecraft.mcore4.cmd.req.ReqHasPerm;
import com.massivecraft.mcore4.cmd.req.ReqIsPlayer;

public class CmdBiomeToolConvert extends BiomeToolCommand
{
	public CmdBiomeToolConvert()
	{
		super();
		this.addAliases("convert");
		this.addRequiredArg("fromId|all");
		this.addRequiredArg("toId");
		
		this.addRequirements(new ReqHasPerm(Permission.CONVERT.node));
		this.addRequirements(ReqIsPlayer.getInstance());
	}
	
	@Override
	public void perform()
	{
		boolean all = false;
		
		World world = me.getWorld();
		CraftWorld craftWorld = (CraftWorld)world;
		WorldServer worldServer = craftWorld.getHandle();
		
		Integer fromId = null;
		Integer toId = null;
		
		BiomeBase fromBiome = null;
		BiomeBase toBiome = null;
		
		if (this.arg(0).toLowerCase().startsWith("a"))
		{
			all = true;
		}
		else
		{
			fromId = this.arg(0, ARInteger.get());
			if (fromId == null) return;
			fromBiome = BiomeBase.biomes[fromId];
			if (fromBiome == null) {
				msg("<e>Invalid fromId");
				return;
			}
		}
		
		toId = this.arg(1, ARInteger.get());
		if (toId == null) return;
		toBiome = BiomeBase.biomes[toId];
		if (toBiome == null) {
			msg("<e>Invalid toId");
			return;
		}
		
		int xmin = pme.getXMin();
		int xmax = pme.getXMax();
		int zmin = pme.getZMin();
		int zmax = pme.getZMax();
		
		int area = (xmax - xmin + 1) * (zmax - zmin + 1);
		
		msg("<i>Now converting <h>"+area+" coords to <h>"+toBiome.y+"<i>.");
		
		for (int x = xmin; x <= xmax; x++)
		{
			for (int z = zmin; z <= zmax; z++)
			{
				if ( ! all)
				{
					BiomeBase biomeHere = worldServer.getBiome(x, z);
					if (biomeHere.id != fromId)
					{
						continue;
					}
				}
				BiomeUtil.setBiomeId(craftWorld, x, z, toId);
			}
		}
		msg("<i>DONE");
	}
}