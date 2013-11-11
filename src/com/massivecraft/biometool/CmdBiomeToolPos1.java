package com.massivecraft.biometool;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.cmd.req.ReqIsPlayer;

public class CmdBiomeToolPos1 extends BiomeToolCommand
{
	// -------------------------------------------- //
	// CONSTANTS
	// -------------------------------------------- //
	
	public final static String FIRST_HELP_LINE = "<i>Manage the first position from here.";
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeToolPos1()
	{
		// SubCommands
		this.addSubCommand(new CmdBiomeToolPos1Here());
		this.addSubCommand(new CmdBiomeToolPos1Coord());
		
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
