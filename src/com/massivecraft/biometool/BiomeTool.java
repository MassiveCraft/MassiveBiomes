package com.massivecraft.biometool;

import com.massivecraft.mcore.MPlugin;

public class BiomeTool extends MPlugin
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static BiomeTool i;
	public static BiomeTool get() { return i; }
	public BiomeTool() { BiomeTool.i = this; }
    
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
    
	// Commands
	public CmdBiomeTool cmdBiomeTool;
	
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
		this.cmdBiomeTool = new CmdBiomeTool();
		this.cmdBiomeTool.register();
		
		postEnable();
	}
	
}
