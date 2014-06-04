package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.cmd.req.ReqIsPlayer;

public class CmdBiomePos2Here extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePos2Here()
	{
		// Aliases
		this.addAliases("here");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.POS2_HERE.node));
		this.addRequirements(ReqIsPlayer.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform()
	{
		mme.setX2(me.getLocation().getBlockX());
		mme.setZ2(me.getLocation().getBlockZ());
		msg("<i>DONE");
	}
	
}
