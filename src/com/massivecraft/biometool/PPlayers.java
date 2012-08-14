package com.massivecraft.biometool;

import java.io.File;

import com.massivecraft.mcore4.persist.gson.GsonPlayerEntityManager;

public class PPlayers extends GsonPlayerEntityManager<PPlayer>
{
	@Override public Class<PPlayer> getManagedClass() { return PPlayer.class; }
	public static PPlayers i = new PPlayers();
	private PPlayers()
	{
		super(P.p.gson, new File(P.p.getDataFolder(), "player"), true, true);
		P.p.persist.setManager(PPlayer.class, this);
		P.p.persist.setSaveInterval(PPlayer.class, 1000*60*30);
	}

	@Override
	public boolean shouldBeSaved(PPlayer entity)
	{
		return false;
	}
}
