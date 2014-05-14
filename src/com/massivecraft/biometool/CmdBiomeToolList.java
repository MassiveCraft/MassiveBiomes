package com.massivecraft.biometool;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Biome;

import com.massivecraft.mcore.cmd.arg.ARInteger;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.util.Txt;

public class CmdBiomeToolList extends BiomeToolCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeToolList()
	{
		// Aliases
		this.addAliases("l","ls","list");
		
		// Args
		this.addOptionalArg("page", "1");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.LIST.node));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform()
	{
		// Args
		Integer pageHumanBased = this.arg(0, ARInteger.get(), 1);
		if (pageHumanBased == null) return;
		
		// Create Lines
		List<String> lines = new ArrayList<String>();
		
		for (Biome biome : Biome.values())
		{
			Integer id = biome.ordinal();
			String name = biome.toString();
			String line = Txt.parse("<k>%d <v>%s", id, name);
			lines.add(line);
		}
		
		this.sendMessage(Txt.getPage(lines, pageHumanBased, "Biome List", sender));
	}
	
}