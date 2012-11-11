package com.massivecraft.biometool;

import com.massivecraft.mcore5.store.PlayerColl;

public class PPlayerColl extends PlayerColl<PPlayer>
{
	// -------------------------------------------- //
	// META
	// -------------------------------------------- //
	
	public static PPlayerColl i = new PPlayerColl();
	private PPlayerColl()
	{
		// We use default database. Nothing is saved right now.
		// IF you decide to save stuff in the future: implement Const and ConfServer
		super(P.p, "biometool_player", PPlayer.class); 
	}

	// -------------------------------------------- //
	// EXTRAS
	// -------------------------------------------- //

	@Override
	public boolean isDefault(PPlayer entity)
	{
		// always default => never save
		return true;
	}
}
