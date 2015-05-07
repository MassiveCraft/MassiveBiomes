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
		this.addArg(ARInteger.get(), "X");
		this.addArg(ARInteger.get(), "Z");
		
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
		int X = this.readArg();
		int Z = this.readArg();
		
		mme.setX1(X);
		mme.setZ1(Z);
		msg("<i>DONE");
	}
	
}
