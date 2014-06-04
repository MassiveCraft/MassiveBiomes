package com.massivecraft.massivebiomes;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.cmd.req.ReqIsPlayer;

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
		// SubCommands
		this.addSubCommand(new CmdBiomePos1Here());
		this.addSubCommand(new CmdBiomePos1Coord());
		
		// Aliases
		this.addAliases("1", "p1", "pos1");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.POS1.node));
		this.addRequirements(ReqIsPlayer.get());
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
