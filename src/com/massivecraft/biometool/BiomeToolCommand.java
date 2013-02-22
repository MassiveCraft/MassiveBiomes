package com.massivecraft.biometool;

import com.massivecraft.mcore.cmd.MCommand;

public abstract class BiomeToolCommand extends MCommand
{
	public PPlayer pme;
	
	@Override
	public void fixSenderVars()
	{
		this.pme = PPlayerColl.i.get(this.sender);
	}
}
