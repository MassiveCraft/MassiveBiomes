package com.massivecraft.biometool;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.BiomeBase;

import com.massivecraft.mcore4.cmd.req.ReqHasPerm;
import com.massivecraft.mcore4.util.Txt;

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
		Integer pageHumanBased = this.argAs(0, Integer.class, 1);
		if (pageHumanBased == null) return;
		List<String> infors = new ArrayList<String>();
		for (BiomeBase bb : BiomeUtil.getAllBiomeBase())
		{
			infors.add("<k>"+bb.id+" <v>"+bb.y);
		}
		this.sendMessage(Txt.getPage(Txt.parseWrap(Txt.implodeCommaAndDot(infors, "<i>")), pageHumanBased, "Biome List"));	
	}
}