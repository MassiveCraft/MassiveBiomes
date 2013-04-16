package com.massivecraft.biometool;

import com.massivecraft.mcore.store.MStore;
import com.massivecraft.mcore.store.SenderColl;

public class PPlayerColl extends SenderColl<PPlayer>
{
	// -------------------------------------------- //
	// META
	// -------------------------------------------- //
	
	public static PPlayerColl i = new PPlayerColl();
	private PPlayerColl()
	{
		// We use default database. Nothing is saved right now.
		// IF you decide to save stuff in the future: implement Const and ConfServer
		super("biometool_player", PPlayer.class, MStore.getDb("default"), P.p);
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
