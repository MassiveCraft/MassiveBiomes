package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.Lang;
import com.massivecraft.massivebiomes.Perm;
import com.massivecraft.massivebiomes.entity.MConf;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.Parameter;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.pager.Pager;
import com.massivecraft.massivecore.pager.Stringifier;
import com.massivecraft.massivecore.util.Txt;
import org.bukkit.block.Biome;

import java.util.Arrays;
import java.util.List;

public class CmdBiomeList extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeList()
	{
		// Parameters
		this.addParameter(Parameter.getPage());
		
		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.LIST));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesBiomeList;
	}
	
	@Override
	public void perform() throws MassiveException
	{
		// Parameters
		int page = this.readArg();
		
		// Pager Create
		Pager<Biome> pager = new Pager<>(this, Lang.BIOME_LIST_TITLE, page, Arrays.asList(Biome.values()), new Stringifier<Biome>()
		{
			@Override
			public String toString(Biome biome, int index)
			{
				Integer id = biome.ordinal();
				String name = Txt.getNicedEnum(biome);
				return Txt.parse(Lang.BIOME_LIST_ENTRY, id, name);
			}
		});
		
		// Pager Message
		pager.message();
	}
	
}
