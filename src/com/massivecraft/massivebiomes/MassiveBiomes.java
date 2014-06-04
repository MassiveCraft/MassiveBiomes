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
	// FIELDS
	// -------------------------------------------- //
    
	// Commands
	public CmdBiome cmdBiome;
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void onEnable()
	{
		if ( ! preEnable()) return;
		
		// Collections
		MPlayerColl.get().init();
		
		// Commands
		this.cmdBiome = new CmdBiome();
		this.cmdBiome.register();
		
		postEnable();
	}
	
}
