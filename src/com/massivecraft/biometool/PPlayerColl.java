package com.massivecraft.biometool;

import com.massivecraft.mcore5.store.MStore;
import com.massivecraft.mcore5.store.SenderColl;

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
		super(MStore.getDb("default"), P.p, "biometool_player", PPlayer.class);
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
