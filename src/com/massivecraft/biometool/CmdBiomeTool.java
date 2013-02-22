package com.massivecraft.biometool;

import com.massivecraft.mcore.cmd.HelpCommand;

public class CmdBiomeTool extends BiomeToolCommand
{
	public CmdBiomeTool()
	{
		super();
		this.addAliases("bt");
		this.addSubCommand(HelpCommand.getInstance());
		this.addSubCommand(new CmdBiomeToolHere());
		this.addSubCommand(new CmdBiomeToolList());
		this.addSubCommand(new CmdBiomeToolPos1());
		this.addSubCommand(new CmdBiomeToolPos2());
		this.addSubCommand(new CmdBiomeToolConvert());
	}
	
	@Override
	public void perform()
	{
		this.getCommandChain().add(this);
		HelpCommand.getInstance().execute(this.sender, this.args, this.commandChain);
	}
}