package com.massivecraft.massivebiomes.entity;

import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;

import java.util.List;

public class MConf extends Entity<MConf>
{
	// -------------------------------------------- //
	// META
	// -------------------------------------------- //
	
	protected static transient MConf i;
	public static MConf get() { return i; }
	
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	// Aliases
	public List<String> aliasesBiome = MUtil.list("biome", "massivebiome", "mbiome", "mb");
	public List<String> aliasesBiomeHere = MUtil.list("here");
	public List<String> aliasesBiomeList = MUtil.list("list");
	public List<String> aliasesBiomePos1 = MUtil.list("1", "p1", "pos1");
	public List<String> aliasesBiomePosHere = MUtil.list("here");
	public List<String> aliasesBiomePosCoord = MUtil.list("coord");
	public List<String> aliasesBiomePos2 = MUtil.list("2", "p2", "pos2");
	public List<String> aliasesBiomeConvert = MUtil.list("convert");
	public List<String> aliasesBiomeConfig = MUtil.list("config");
	public List<String> aliasesBiomeVersion = MUtil.list("v", "version");
	
}
