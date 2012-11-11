package com.massivecraft.biometool;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.mcore5.cmd.HelpCommand;
import com.massivecraft.mcore5.cmd.req.ReqHasPerm;
import com.massivecraft.mcore5.cmd.req.ReqIsPlayer;

public class CmdBiomeToolPos1 extends BiomeToolCommand
{
	public CmdBiomeToolPos1()
	{
		super();
		this.addAliases("1", "p1", "pos1");
		this.addRequirements(new ReqHasPerm(Permission.POS1.node));
		this.addRequirements(ReqIsPlayer.getInstance());
		
		this.addSubCommand(new CmdBiomeToolPos1Here());
		this.addSubCommand(new CmdBiomeToolPos1Coord());
	}
	
	protected final static String firstHelpLine = "<i>Manage the first position from here.";
	@Override
	public List<String> getHelp()
	{
		List<String> ret = new ArrayList<String>(2);
		ret.add(firstHelpLine);
		ret.add("<i>Currently <k>X<v>"+pme.x1+" <k>Z<v>"+pme.z1);
		return ret;
	}
	
	@Override
	public void perform()
	{
		this.getCommandChain().add(this);
		HelpCommand.getInstance().execute(this.sender, this.args, this.commandChain);
	}
}