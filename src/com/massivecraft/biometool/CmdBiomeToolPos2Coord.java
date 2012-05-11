package com.massivecraft.biometool;

import com.massivecraft.mcore3.cmd.req.ReqHasPerm;
import com.massivecraft.mcore3.cmd.req.ReqIsPlayer;

public class CmdBiomeToolPos2Coord extends BiomeToolCommand
{
	public CmdBiomeToolPos2Coord()
	{
		super();
		this.addAliases("coord");
		this.addRequiredArg("X");
		this.addRequiredArg("Z");
		this.addRequirements(new ReqHasPerm(Permission.POS2_COORD.node));
		this.addRequirements(ReqIsPlayer.getInstance());
	}
	
	@Override
	public void perform()
	{
		Integer X = this.argAs(0, Integer.class);
		if (X == null) return;
		
		Integer Z = this.argAs(1, Integer.class);
		if (Z == null) return;
		
		pme.setX2(X);
		pme.setZ2(Z);
		msg("<i>DONE");
	}
}