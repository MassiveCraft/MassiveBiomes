package com.massivecraft.biometool;

import com.massivecraft.mcore5.cmd.req.ReqHasPerm;
import com.massivecraft.mcore5.cmd.req.ReqIsPlayer;

public class CmdBiomeToolPos2Here extends BiomeToolCommand
{
	public CmdBiomeToolPos2Here()
	{
		super();
		this.addAliases("here");
		this.addRequirements(new ReqHasPerm(Permission.POS2_HERE.node));
		this.addRequirements(ReqIsPlayer.getInstance());
	}
	
	@Override
	public void perform()
	{
		pme.setX2(me.getLocation().getBlockX());
		pme.setZ2(me.getLocation().getBlockZ());
		msg("<i>DONE");
	}
}