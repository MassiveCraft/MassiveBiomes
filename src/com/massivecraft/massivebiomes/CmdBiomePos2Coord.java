package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.cmd.MassiveCommandException;
import com.massivecraft.massivecore.cmd.arg.ARInteger;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.cmd.req.ReqIsPlayer;

public class CmdBiomePos2Coord extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePos2Coord()
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
	public void perform() throws MassiveCommandException
	{
		Integer X = this.arg(0, ARInteger.get());
		Integer Z = this.arg(1, ARInteger.get());
		
		mme.setX2(X);
		mme.setZ2(Z);
		msg("<i>DONE");
	}
	
}
