package com.massivecraft.massivebiomes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Biome;

import com.massivecraft.massivecore.cmd.MassiveCommandException;
import com.massivecraft.massivecore.cmd.arg.ARInteger;
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
		this.addOptionalArg("page", "1");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.LIST.node));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveCommandException
	{
		// Args
		Integer pageHumanBased = this.arg(0, ARInteger.get(), 1);
		
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