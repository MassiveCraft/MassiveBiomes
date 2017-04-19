package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.SelectionPosition;
import com.massivecraft.massivebiomes.entity.MConf;

import java.util.List;

public class CmdBiomePos2 extends CmdBiomePosAbstract
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePos2()
	{
		// Super
		super(SelectionPosition.SECOND);
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesBiomePos2;
	}
	
}
