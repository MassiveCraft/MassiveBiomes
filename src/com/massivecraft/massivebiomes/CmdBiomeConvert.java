package com.massivecraft.massivebiomes;

import org.bukkit.World;
import org.bukkit.block.Biome;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.cmd.arg.ARBiome;
import com.massivecraft.massivecore.cmd.arg.ARNullable;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.cmd.req.ReqIsPlayer;

public class CmdBiomeConvert extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeConvert()
	{
		// Aliases
		this.addAliases("convert");
		
		// Args
		this.addArg(ARNullable.get(ARBiome.get(), "all"), "fromId|all");
		this.addArg(ARBiome.get(), "toId");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.CONVERT.node));
		this.addRequirements(ReqIsPlayer.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveException
	{
		World world = me.getWorld();
		
		Biome from = this.readArg();
		Biome to = this.readArg();
		
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
				if (from != null)
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