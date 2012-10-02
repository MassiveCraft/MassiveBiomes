package com.massivecraft.biometool;

import com.massivecraft.mcore4.cmd.MCommand;

public abstract class BiomeToolCommand extends MCommand
{
	public P p;
	public BiomeToolCommand()
	{
		super();
		this.p = P.p;
	}
	
	@Override
	public P p()
	{
		return P.p;
	}
	
	public PPlayer pme;
	@Override
	public void fixSenderVars()
	{
		this.pme = PPlayerColl.i.get(this.me);
	}
	
}
