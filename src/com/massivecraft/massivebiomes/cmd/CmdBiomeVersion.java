package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.MassiveBiomes;
import com.massivecraft.massivebiomes.Perm;
import com.massivecraft.massivebiomes.entity.MConf;
import com.massivecraft.massivecore.command.MassiveCommandVersion;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;

import java.util.List;

public class CmdBiomeVersion extends MassiveCommandVersion
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomeVersion()
	{
		super(MassiveBiomes.get());
		
		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.VERSION));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesBiomeVersion;
	}
	
}
