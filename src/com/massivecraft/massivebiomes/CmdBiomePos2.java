package com.massivecraft.massivebiomes;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;

public class CmdBiomePos2 extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTANTS
	// -------------------------------------------- //
	
	public final static String FIRST_HELP_LINE = "<i>Manage the second position from here.";
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePos2()
	{
		// Children
		this.addChild(new CmdBiomePos2Here());
		this.addChild(new CmdBiomePos2Coord());
		
		// Aliases
		this.addAliases("2", "p2", "pos2");
		
		// Requirements
		this.addRequirements(new RequirementHasPerm(Perm.POS2));
		this.addRequirements(RequirementIsPlayer.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getHelp()
	{
		List<String> ret = new ArrayList<String>(2);
		ret.add(FIRST_HELP_LINE);
		ret.add("<i>Currently <k>X<v>"+mme.x2+" <k>Z<v>"+mme.z2);
		return ret;
	}
	
}
