package com.massivecraft.biometool;

import com.massivecraft.mcore.cmd.arg.ARInteger;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.cmd.req.ReqIsPlayer;

public class CmdBiomeToolPos2Coord extends BiomeToolCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeToolPos2Coord()
	{
		// Aliases
		this.addAliases("coord");
		
		// Args
		this.addRequiredArg("X");
		this.addRequiredArg("Z");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.POS2_COORD.node));
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
		
		mme.setX2(X);
		mme.setZ2(Z);
		msg("<i>DONE");
	}
	
}
