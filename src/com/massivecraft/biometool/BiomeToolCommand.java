package com.massivecraft.biometool;

import com.massivecraft.mcore.cmd.MCommand;

public abstract class BiomeToolCommand extends MCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public MPlayer mme;
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void fixSenderVars()
	{
		this.mme = MPlayerColl.get().get(this.sender);
	}
	
}
