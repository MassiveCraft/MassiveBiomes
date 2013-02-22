package com.massivecraft.biometool;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.mcore.cmd.HelpCommand;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.cmd.req.ReqIsPlayer;

public class CmdBiomeToolPos2 extends BiomeToolCommand
{
	public CmdBiomeToolPos2()
	{
		super();
		this.addAliases("2", "p2", "pos2");
		this.addRequirements(new ReqHasPerm(Permission.POS2.node));
		this.addRequirements(ReqIsPlayer.get());
		
		this.addSubCommand(new CmdBiomeToolPos2Here());
		this.addSubCommand(new CmdBiomeToolPos2Coord());
	}
	
	protected final static String firstHelpLine = "<i>Manage the second position from here.";
	@Override
	public List<String> getHelp()
	{
		List<String> ret = new ArrayList<String>(2);
		ret.add(firstHelpLine);
		ret.add("<i>Currently <k>X<v>"+pme.x2+" <k>Z<v>"+pme.z2);
		return ret;
	}
	
	@Override
	public void perform()
	{
		this.getCommandChain().add(this);
		HelpCommand.getInstance().execute(this.sender, this.args, this.commandChain);
	}
}