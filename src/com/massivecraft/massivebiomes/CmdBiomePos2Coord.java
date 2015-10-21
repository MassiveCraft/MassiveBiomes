package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.cmd.req.ReqIsPlayer;
import com.massivecraft.massivecore.cmd.type.TypeInteger;

public class CmdBiomePos2Coord extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePos2Coord()
	{
		// Aliases
		this.addAliases("coord");
		
		// Parameters
		this.addParameter(TypeInteger.get(), "X");
		this.addParameter(TypeInteger.get(), "Z");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Perm.POS2_COORD.node));
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
		
		mme.setX2(X);
		mme.setZ2(Z);
		msg("<i>DONE");
	}
	
}
