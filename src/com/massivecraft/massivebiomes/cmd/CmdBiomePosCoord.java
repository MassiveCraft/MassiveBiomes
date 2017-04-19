package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.Perm;
import com.massivecraft.massivebiomes.SelectionPosition;
import com.massivecraft.massivebiomes.entity.MConf;
import com.massivecraft.massivecore.Couple;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.type.primitive.TypeInteger;

import java.util.List;

public class CmdBiomePosCoord extends CommandBiomePosSetAbstract
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePosCoord(SelectionPosition selectionPosition)
	{
		super(selectionPosition);
		
		// Parameters
		this.addParameter(TypeInteger.get(), "X");
		this.addParameter(TypeInteger.get(), "Z");
		
		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.POS_COORD));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesBiomePosCoord;
	}
	
	@Override
	public Couple<Integer, Integer> getXZ() throws MassiveException
	{
		// Parameters
		int coordX = this.readArg();
		int coordZ = this.readArg();
		
		return new Couple<>(coordX, coordZ);
	}
	
}
