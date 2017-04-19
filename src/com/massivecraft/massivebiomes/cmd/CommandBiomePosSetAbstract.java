package com.massivecraft.massivebiomes.cmd;

import com.massivecraft.massivebiomes.Lang;
import com.massivecraft.massivebiomes.SelectionPosition;
import com.massivecraft.massivecore.Couple;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;

public abstract class CommandBiomePosSetAbstract extends MassiveBiomesCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	private SelectionPosition selectionPosition;
	public SelectionPosition getSelectionPosition() { return this.selectionPosition; }
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CommandBiomePosSetAbstract(SelectionPosition selectionPosition)
	{
		this.selectionPosition = selectionPosition;
		
		// Requirements
		this.addRequirements(RequirementIsPlayer.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveException
	{
		// Get the user's location
		Couple<Integer, Integer> coords = this.getXZ();
		int blockX = coords.getFirst();
		int blockZ = coords.getSecond();
		
		// Save
		mme.setX(blockX, this.getSelectionPosition());
		mme.setZ(blockZ, this.getSelectionPosition());
		
		// Inform
		msg(Lang.POSITION_W_NOW_X_Z, this.getSelectionPosition().ordinal() + 1, blockX, blockZ);
	}
	
	// -------------------------------------------- //
	// ABSTRACT
	// -------------------------------------------- //
	
	public abstract Couple<Integer, Integer> getXZ() throws MassiveException;
	
}
