package com.massivecraft.biometool;

import com.massivecraft.mcore4.cmd.req.ReqHasPerm;
import com.massivecraft.mcore4.cmd.req.ReqIsPlayer;

public class CmdBiomeToolPos1Coord extends BiomeToolCommand
{
	public CmdBiomeToolPos1Coord()
	{
		super();
		this.addAliases("coord");
		this.addRequiredArg("X");
		this.addRequiredArg("Z");
		this.addRequirements(new ReqHasPerm(Permission.POS1_COORD.node));
		this.addRequirements(ReqIsPlayer.getInstance());
	}
	
	@Override
	public void perform()
	{
		Integer X = this.argAs(0, Integer.class);
		if (X == null) return;
		
		Integer Z = this.argAs(1, Integer.class);
		if (Z == null) return;
		
		pme.setX1(X);
		pme.setZ1(Z);
		msg("<i>DONE");
	}
}