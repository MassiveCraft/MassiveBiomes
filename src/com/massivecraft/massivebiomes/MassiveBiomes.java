package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.MassivePlugin;

public class MassiveBiomes extends MassivePlugin
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static MassiveBiomes i;
	public static MassiveBiomes get() { return i; }
	public MassiveBiomes() { MassiveBiomes.i = this; }
    
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void onEnableInner()
	{
		// Activate
		this.activate(
			// Coll
			MPlayerColl.get(),
		
			// Command
			CmdBiome.get()
		);
	}
	
}
