package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.cmd.arg.ARInteger;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.cmd.req.ReqIsPlayer;

public class CmdBiomePos1Coord extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePos1Coord()
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
	public void perform() throws MassiveException
	{
		Integer X = this.arg(0, ARInteger.get());
		Integer Z = this.arg(1, ARInteger.get());
		
		mme.setX1(X);
		mme.setZ1(Z);
		msg("<i>DONE");
	}
	
}
