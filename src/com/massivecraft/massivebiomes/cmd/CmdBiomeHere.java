package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.Lang;
import com.massivecraft.massivebiomes.Perm;
import com.massivecraft.massivebiomes.entity.MConf;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;

import java.util.List;

public class CmdBiomeHere extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeHere()
	{
		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.HERE));
		this.addRequirements(RequirementIsPlayer.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesBiomeHere;
	}
	
	@Override
	public void perform()
	{
		// Get the user's location
		Location location = this.me.getLocation();
		World world = location.getWorld();
		int blockX = location.getBlockX();
		int blockZ = location.getBlockZ();
		
		// Get biome
		Biome biome = world.getBiome(blockX, blockZ);
		
		// Get what we want to say about the biome
		Integer id = biome.ordinal();
		String name = biome.toString();
		
		// Inform
		msg(Lang.BIOME_HERE_ID_NAME, id, name);
	}
	
}
