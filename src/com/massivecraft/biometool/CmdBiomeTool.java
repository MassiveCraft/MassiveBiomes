package com.massivecraft.biometool;

import com.massivecraft.mcore.cmd.HelpCommand;
import com.massivecraft.mcore.cmd.VersionCommand;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;

public class CmdBiomeTool extends BiomeToolCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public CmdBiomeToolHere cmdBiomeToolHere = new CmdBiomeToolHere();
	public CmdBiomeToolList cmdBiomeToolList = new CmdBiomeToolList();
	public CmdBiomeToolPos1 cmdBiomeToolPos1 = new CmdBiomeToolPos1();
	public CmdBiomeToolPos2 cmdBiomeToolPos2 = new CmdBiomeToolPos2();
	public CmdBiomeToolConvert cmdBiomeToolConvert = new CmdBiomeToolConvert();
	public VersionCommand cmdBiomeToolVersion = new VersionCommand(BiomeTool.get(), Perm.VERSION.node, "v", "version");
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeTool()
	{
		// SubCommands
		this.addSubCommand(HelpCommand.get());
		this.addSubCommand(this.cmdBiomeToolHere);
		this.addSubCommand(this.cmdBiomeToolList);
		this.addSubCommand(this.cmdBiomeToolPos1);
		this.addSubCommand(this.cmdBiomeToolPos2);
		this.addSubCommand(this.cmdBiomeToolConvert);
		this.addSubCommand(this.cmdBiomeToolVersion);
		
		// Aliases
		this.addAliases("bt");
		
		// Requirements
		this.addRequirements(ReqHasPerm.get(Perm.BASECOMMAND.node));
	}

}
