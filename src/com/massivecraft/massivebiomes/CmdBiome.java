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
		// Children
		this.addChild(this.cmdBiomeHere);
		this.addChild(this.cmdBiomeList);
		this.addChild(this.cmdBiomePos1);
		this.addChild(this.cmdBiomePos2);
		this.addChild(this.cmdBiomeConvert);
		this.addChild(this.cmdBiomeVersion);
		
		// Aliases
		this.addAliases("biome");
		
		// Requirements
		this.addRequirements(ReqHasPerm.get(Perm.BASECOMMAND.node));
	}

}
