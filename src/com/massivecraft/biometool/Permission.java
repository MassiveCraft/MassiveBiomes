package com.massivecraft.biometool;

import org.bukkit.command.CommandSender;

import com.massivecraft.mcore3.util.Perm;

public enum Permission
{
	HERE("here"),
	LIST("list"),
	POS1("pos1"),
	POS1_HERE("pos1.here"),
	POS1_COORD("pos1.coord"),
	POS2("pos2"),
	POS2_HERE("pos2.here"),
	POS2_COORD("pos2.coord"),
	CONVERT("convert"),
	;
	
	public final String node;
	
	Permission(final String node)
	{
		this.node = "biometool."+node;
    }
	
	public boolean has(CommandSender sender, boolean informSenderIfNot)
	{
		return Perm.has(sender, this.node, informSenderIfNot);
	}
	
	public boolean has(CommandSender sender)
	{
		return has(sender, false);
	}
}
