package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.command.type.primitive.TypeInteger;

public class CmdBiomePos1Coord extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePos1Coord()
	{
		// Aliases
		this.addAliases("coord");
		
		// Parameters
		this.addParameter(TypeInteger.get(), "X");
		this.addParameter(TypeInteger.get(), "Z");
		
		// Requirements
		this.addRequirements(new RequirementHasPerm(Perm.POS1_COORD.node));
		this.addRequirements(RequirementIsPlayer.get());
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
