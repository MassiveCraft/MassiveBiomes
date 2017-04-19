package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.SelectionPosition;
import com.massivecraft.massivebiomes.entity.MConf;

import java.util.List;

public class CmdBiomePos1 extends CmdBiomePosAbstract
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePos1()
	{
		// Super
		super(SelectionPosition.FIRST);
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesBiomePos1;
	}
	
}
