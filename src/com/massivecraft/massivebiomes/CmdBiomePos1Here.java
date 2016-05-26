package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;

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
		this.addRequirements(new RequirementHasPerm(Perm.POS1_HERE.id));
		this.addRequirements(RequirementIsPlayer.get());
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
