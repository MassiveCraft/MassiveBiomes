package com.massivecraft.biometool;

import com.massivecraft.mcore5.MPlugin;

public class P extends MPlugin
{
	// Our single instance
    public static P p;
    
	// Command
	public CmdBiomeTool cmdBiomeTool;
	
	public P()
	{
		P.p = this;
	}
	
	@Override
	public void onEnable()
	{
		if ( ! preEnable()) return;
		
		PPlayerColl.i.init();
		
		// Add Base Commands
		this.cmdBiomeTool = new CmdBiomeTool();
		this.cmdBiomeTool.register();
		
		postEnable();
	}
}
