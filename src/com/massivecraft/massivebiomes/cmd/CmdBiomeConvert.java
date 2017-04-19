package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.Lang;
import com.massivecraft.massivebiomes.Perm;
import com.massivecraft.massivebiomes.entity.MConf;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.command.type.TypeNullable;
import com.massivecraft.massivecore.command.type.enumeration.TypeBiome;
import org.bukkit.World;
import org.bukkit.block.Biome;

import java.util.List;

public class CmdBiomeConvert extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeConvert()
	{
		// Parameters
		this.addParameter(TypeNullable.get(TypeBiome.get(), "all"), "fromId|all");
		this.addParameter(TypeBiome.get(), "toId");
		
		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.CONVERT));
		this.addRequirements(RequirementIsPlayer.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesBiomeConvert;
	}
	
	@Override
	public void perform() throws MassiveException
	{
		// Parameters
		World world = me.getWorld();
		Biome from = this.readArg();
		Biome to = this.readArg();
		
		// Get the min and max values of the region
		int xmin = mme.getXMin();
		int xmax = mme.getXMax();
		int zmin = mme.getZMin();
		int zmax = mme.getZMax();
		
		int area = (xmax - xmin + 1) * (zmax - zmin + 1);
		
		boolean fromAll = from == null;
		
		// Convert
		for (int x = xmin; x <= xmax; x++)
		{
			for (int z = zmin; z <= zmax; z++)
			{
				if (!fromAll && world.getBiome(x, z) != from) continue;
				world.setBiome(x, z, to);
			}
		}
		
		// Inform
		msg(Lang.CONVERTED_X_COORDS_TO_Y_BIOME, area, to);
	}
	
}
