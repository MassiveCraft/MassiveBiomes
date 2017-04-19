package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.Perm;
import com.massivecraft.massivebiomes.entity.MConf;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;

import java.util.List;

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
	public CmdBiomeConfig cmdBiomeConfig = new CmdBiomeConfig();
	public CmdBiomeVersion cmdBiomeVersion = new CmdBiomeVersion();
	
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
		this.addChild(this.cmdBiomeConfig);
		this.addChild(this.cmdBiomeVersion);
		
		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.BASECOMMAND));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesBiome;
	}

}
