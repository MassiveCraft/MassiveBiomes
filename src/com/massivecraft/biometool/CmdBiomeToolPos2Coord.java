package com.massivecraft.biometool;

import com.massivecraft.mcore5.cmd.arg.ARInteger;
import com.massivecraft.mcore5.cmd.req.ReqHasPerm;
import com.massivecraft.mcore5.cmd.req.ReqIsPlayer;

public class CmdBiomeToolPos2Coord extends BiomeToolCommand
{
	public CmdBiomeToolPos2Coord()
	{
		super();
		this.addAliases("coord");
		this.addRequiredArg("X");
		this.addRequiredArg("Z");
		this.addRequirements(new ReqHasPerm(Permission.POS2_COORD.node));
		this.addRequirements(ReqIsPlayer.get());
	}
	
	@Override
	public void perform()
	{
		Integer X = this.arg(0, ARInteger.get());
		if (X == null) return;
		
		Integer Z = this.arg(1, ARInteger.get());
		if (Z == null) return;
		
		pme.setX2(X);
		pme.setZ2(Z);
		msg("<i>DONE");
	}
}