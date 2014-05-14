package com.massivecraft.biometool;

import org.bukkit.World;
import org.bukkit.block.Biome;

import com.massivecraft.mcore.cmd.arg.ARBiome;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.cmd.req.ReqIsPlayer;

public class CmdBiomeToolConvert extends BiomeToolCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeToolConvert()
	{
		// Aliases
		this.addAliases("convert");
		
		// Args
		this.addRequiredArg("fromId|all");
		this.addRequiredArg("toId");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.CONVERT.node));
		this.addRequirements(ReqIsPlayer.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform()
	{
		World world = me.getWorld();
		boolean all = false;
		
		Biome from = null;
		Biome to = null;
		
		if (this.arg(0).toLowerCase().startsWith("a"))
		{
			all = true;
		}
		else
		{
			from = this.arg(0, ARBiome.get());
			if (from == null) return;
		}
		
		to = this.arg(1, ARBiome.get());
		if (to == null) return;
		
		int xmin = mme.getXMin();
		int xmax = mme.getXMax();
		int zmin = mme.getZMin();
		int zmax = mme.getZMax();
		
		int area = (xmax - xmin + 1) * (zmax - zmin + 1);
		
		msg("<i>Now converting <h>" + area + " coords to <h>" + to + "<i>.");
		
		for (int x = xmin; x <= xmax; x++)
		{
			for (int z = zmin; z <= zmax; z++)
			{
				if ( ! all)
				{
					Biome biomeHere = world.getBiome(x, z);
					if (biomeHere != from)
					{
						continue;
					}
				}
				world.setBiome(x, z, to);
			}
		}
		msg("<i>DONE");
	}
	
}