package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.Perm;
import com.massivecraft.massivebiomes.SelectionPosition;
import com.massivecraft.massivebiomes.entity.MConf;
import com.massivecraft.massivecore.Couple;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import org.bukkit.Location;

import java.util.List;

public class CmdBiomePosHere extends CommandBiomePosSetAbstract
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePosHere(SelectionPosition selectionPosition)
	{
		super(selectionPosition);
		
		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.POS_HERE));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesBiomePosHere;
	}
	
	@Override
	public Couple<Integer, Integer> getXZ()
	{
		Location location = this.me.getLocation();
		return new Couple<>(location.getBlockX(), location.getBlockZ());
	}
	
}
