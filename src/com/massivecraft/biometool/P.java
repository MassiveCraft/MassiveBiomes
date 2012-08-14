package com.massivecraft.biometool;

import com.massivecraft.mcore4.MPlugin;

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
		
		// Add Base Commands
		this.cmdBiomeTool = new CmdBiomeTool();
		this.cmdBiomeTool.register();
		
		// Add Argument Handlers
		/*this.cmd.setArgHandler(Gate.class, AHGate.getInstance());
		this.cmd.setArgHandler(Trigger.class, AHTrigger.getInstance());
		this.cmd.setArgHandler(Action.class, AHAction.getInstance());
		this.cmd.setArgHandler(Effect.class, AHEffect.getInstance());*/		
		
		// Register events
		/*this.theListener = new TheListener(this);
		Bukkit.getServer().getPluginManager().registerEvents(this.theListener, this);*/
		
		postEnable();
	}
}
