package com.massivecraft.biometool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.massivecraft.mcore5.cmd.arg.ARInteger;
import com.massivecraft.mcore5.cmd.req.ReqHasPerm;
import com.massivecraft.mcore5.util.BiomeUtil;
import com.massivecraft.mcore5.util.Txt;

public class CmdBiomeToolList extends BiomeToolCommand
{
	public CmdBiomeToolList()
	{
		super();
		this.addAliases("l","ls","list");
		this.addOptionalArg("page", "1");
		this.addRequirements(new ReqHasPerm(Permission.LIST.node));
	}
	
	@Override
	public void perform()
	{
		Integer pageHumanBased = this.arg(0, ARInteger.get(), 1);
		if (pageHumanBased == null) return;
		List<String> infors = new ArrayList<String>();
		for (Entry<Integer, String> idAndName : BiomeUtil.getBiomeIdNames().entrySet())
		{
			infors.add("<k>"+idAndName.getKey()+" <v>"+idAndName.getValue());
		}
		this.sendMessage(Txt.getPage(Txt.parseWrap(Txt.implodeCommaAndDot(infors, "<i>")), pageHumanBased, "Biome List", sender));
	}
}