package com.massivecraft.massivebiomes;

import java.util.Arrays;

import org.bukkit.block.Biome;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.Parameter;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.pager.Pager;
import com.massivecraft.massivecore.pager.Stringifier;
import com.massivecraft.massivecore.util.Txt;

public class CmdBiomeList extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeList()
	{
		// Aliases
		this.addAliases("list");
		
		// Parameters
		this.addParameter(Parameter.getPage());
		
		// Requirements
		this.addRequirements(new RequirementHasPerm(Perm.LIST));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveException
	{
		// Args
		int page = this.readArg();
		
		// Pager Create
		Pager<Biome> pager = new Pager<Biome>(this, "Biome List", page, Arrays.asList(Biome.values()), new Stringifier<Biome>()
		{
			@Override
			public String toString(Biome biome, int index)
			{
				Integer id = biome.ordinal();
				String name = biome.toString();
				return Txt.parse("<k>%d <v>%s", id, name);
			}
		});
		
		// Pager Message
		pager.message();
	}
	
}