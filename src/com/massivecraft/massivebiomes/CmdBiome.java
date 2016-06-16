package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.command.MassiveCommandVersion;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;

public class CmdBiome extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// INSTANCE
	// -------------------------------------------- //
	
	private static CmdBiome i = new CmdBiome();
	public static CmdBiome get() { return i; }
	
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public CmdBiomeHere cmdBiomeHere = new CmdBiomeHere();
	public CmdBiomeList cmdBiomeList = new CmdBiomeList();
	public CmdBiomePos1 cmdBiomePos1 = new CmdBiomePos1();
	public CmdBiomePos2 cmdBiomePos2 = new CmdBiomePos2();
	public CmdBiomeConvert cmdBiomeConvert = new CmdBiomeConvert();
	public MassiveCommandVersion cmdBiomeVersion = new MassiveCommandVersion(MassiveBiomes.get()).addAliases("v", "version").addRequirements(RequirementHasPerm.get(Perm.VERSION));
	
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
		this.addRequirements(RequirementHasPerm.get(Perm.BASECOMMAND));
	}

}
