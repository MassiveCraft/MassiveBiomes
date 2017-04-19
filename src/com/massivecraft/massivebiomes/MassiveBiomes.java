package com.massivecraft.massivebiomes;

import com.massivecraft.massivebiomes.cmd.CmdBiome;
import com.massivecraft.massivebiomes.entity.MConfColl;
import com.massivecraft.massivebiomes.entity.MPlayerColl;
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
			MPlayerColl.class,
			MConfColl.class,
		
			// Command
			CmdBiome.class
		);
	}
	
}
