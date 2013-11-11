package com.massivecraft.biometool;

import com.massivecraft.mcore.cmd.arg.ARInteger;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.cmd.req.ReqIsPlayer;

public class CmdBiomeToolPos1Coord extends BiomeToolCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeToolPos1Coord()
	{
		// Aliases
		this.addAliases("coord");
		
		// Args
		this.addRequiredArg("X");
		this.addRequiredArg("Z");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.POS1_COORD.node));
		this.addRequirements(ReqIsPlayer.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform()
	{
		Integer X = this.arg(0, ARInteger.get());
		if (X == null) return;
		
		Integer Z = this.arg(1, ARInteger.get());
		if (Z == null) return;
		
		mme.setX1(X);
		mme.setZ1(Z);
		msg("<i>DONE");
	}
	
}
