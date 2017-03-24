package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;

import java.util.ArrayList;
import java.util.List;

public class CmdBiomePos1 extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTANTS
	// -------------------------------------------- //
	
	public final static String FIRST_HELP_LINE = "<i>Manage the first position from here.";
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePos1()
	{
		// Children
		this.addChild(new CmdBiomePos1Here());
		this.addChild(new CmdBiomePos1Coord());
		
		// Aliases
		this.addAliases("1", "p1", "pos1");
		
		// Requirements
		this.addRequirements(new RequirementHasPerm(Perm.POS1));
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
		ret.add("<i>Currently <k>X<v>"+mme.x1+" <k>Z<v>"+mme.z1);
		return ret;
	}

}
