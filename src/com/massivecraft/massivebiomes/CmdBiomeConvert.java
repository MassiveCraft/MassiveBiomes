package com.massivecraft.massivebiomes;

import org.bukkit.World;
import org.bukkit.block.Biome;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.command.type.TypeNullable;
import com.massivecraft.massivecore.command.type.enumeration.TypeBiome;

public class CmdBiomeConvert extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeConvert()
	{
		// Aliases
		this.addAliases("convert");
		
		// Parameters
		this.addParameter(TypeNullable.get(TypeBiome.get(), "all"), "fromId|all");
		this.addParameter(TypeBiome.get(), "toId");
		
		// Requirements
		this.addRequirements(new RequirementHasPerm(Perm.CONVERT.id));
		this.addRequirements(RequirementIsPlayer.get());
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