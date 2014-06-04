package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.cmd.req.ReqIsPlayer;

public class CmdBiomePos1Here extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePos1Here()
	{
		// Aliases
		this.addAliases("here");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.POS1_HERE.node));
		this.addRequirements(ReqIsPlayer.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform()
	{
		mme.setX1(me.getLocation().getBlockX());
		mme.setZ1(me.getLocation().getBlockZ());
		msg("<i>DONE");
	}
	
}
