package com.massivecraft.massivebiomes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Biome;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.cmd.ArgSetting;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.util.Txt;

public class CmdBiomeList extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeList()
	{
		// Aliases
		this.addAliases("l","ls","list");
		
		// Args
		this.addArg(ArgSetting.getPage());
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.LIST.node));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveException
	{
		// Args
		int page = this.readArg();
		
		// Create Lines
		List<String> lines = new ArrayList<String>();
		
		for (Biome biome : Biome.values())
		{
			Integer id = biome.ordinal();
			String name = biome.toString();
			String line = Txt.parse("<k>%d <v>%s", id, name);
			lines.add(line);
		}
		
		this.message(Txt.getPage(lines, page, "Biome List", sender));
	}
	
}