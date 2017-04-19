package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.Lang;
import com.massivecraft.massivebiomes.Perm;
import com.massivecraft.massivebiomes.SelectionPosition;
import com.massivecraft.massivecore.collections.MassiveList;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.util.Txt;

import java.util.List;

public abstract class CmdBiomePosAbstract extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	private final SelectionPosition selectionPosition;
	public SelectionPosition getSelectionPosition() { return this.selectionPosition; }
	
	public CmdBiomePosHere cmdBiomePosHere;
	public CmdBiomePosCoord cmdBiomePosCoord;
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdBiomePosAbstract(SelectionPosition selectionPosition)
	{
		// Fields
		this.selectionPosition = selectionPosition;
		this.cmdBiomePosHere = new CmdBiomePosHere(selectionPosition);
		this.cmdBiomePosCoord = new CmdBiomePosCoord(selectionPosition);
		
		// Children
		this.addChild(this.cmdBiomePosHere);
		this.addChild(this.cmdBiomePosCoord);
		
		// Requirements
		this.addRequirements(RequirementIsPlayer.get());
		this.addRequirements(RequirementHasPerm.get(Perm.POS));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<String> getHelp()
	{
		// Create
		List<String> ret = new MassiveList<>();
		
		// Fill
		ret.add(Txt.parse(Lang.BIOME_POS_X_HELP_HEADER, this.getSelectionPosition().name().toLowerCase()));
		ret.add(Txt.parse(Lang.CURRENTLY_USING_X_Z, mme.getX(this.getSelectionPosition()), mme.getZ(this.getSelectionPosition())));
		
		// Return
		return ret;
	}

}
