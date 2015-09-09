package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.cmd.VersionCommand;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;

public class CmdBiome extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public CmdBiomeHere cmdBiomeHere = new CmdBiomeHere();
	public CmdBiomeList cmdBiomeList = new CmdBiomeList();
	public CmdBiomePos1 cmdBiomePos1 = new CmdBiomePos1();
	public CmdBiomePos2 cmdBiomePos2 = new CmdBiomePos2();
	public CmdBiomeConvert cmdBiomeConvert = new CmdBiomeConvert();
	public VersionCommand cmdBiomeVersion = new VersionCommand(MassiveBiomes.get(), Perm.VERSION.node, "v", "version");
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiome()
	{
		// SubCommands
		this.addSubCommand(this.cmdBiomeHere);
		this.addSubCommand(this.cmdBiomeList);
		this.addSubCommand(this.cmdBiomePos1);
		this.addSubCommand(this.cmdBiomePos2);
		this.addSubCommand(this.cmdBiomeConvert);
		this.addSubCommand(this.cmdBiomeVersion);
		
		// Aliases
		this.addAliases("biome");
		
		// Requirements
		this.addRequirements(ReqHasPerm.get(Perm.BASECOMMAND.node));
	}

}
