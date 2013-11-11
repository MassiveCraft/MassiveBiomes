package com.massivecraft.biometool;

import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.cmd.req.ReqIsPlayer;

public class CmdBiomeToolPos1Here extends BiomeToolCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeToolPos1Here()
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
