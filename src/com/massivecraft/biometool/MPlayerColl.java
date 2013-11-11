package com.massivecraft.biometool;

import com.massivecraft.mcore.store.MStore;
import com.massivecraft.mcore.store.SenderColl;

public class MPlayerColl extends SenderColl<MPlayer>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static MPlayerColl i = new MPlayerColl();
	public static MPlayerColl get() { return i; }
	private MPlayerColl()
	{
		super("biometool_mplayer", MPlayer.class, MStore.getDb(), BiomeTool.get());
	}

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //

	@Override
	public boolean isDefault(MPlayer entity)
	{
		// always default => never save
		return true;
	}
	
}
