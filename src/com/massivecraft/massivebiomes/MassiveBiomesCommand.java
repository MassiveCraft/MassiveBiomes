package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.cmd.MassiveCommand;

public abstract class MassiveBiomesCommand extends MassiveCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public MPlayer mme;
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void senderFields(boolean set)
	{
		this.mme = set ? MPlayerColl.get().get(this.sender) : null;
	}
	
}
