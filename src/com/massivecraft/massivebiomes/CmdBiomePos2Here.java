package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;

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
		this.addRequirements(new RequirementHasPerm(Perm.POS2_HERE.node));
		this.addRequirements(RequirementIsPlayer.get());
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
