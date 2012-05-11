package com.massivecraft.biometool;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.craftbukkit.CraftWorld;

import net.minecraft.server.BiomeBase;

public class BiomeUtil
{
	public static List<BiomeBase> getAllBiomeBase()
	{
		List<BiomeBase> ret = new ArrayList<BiomeBase>();
		for(BiomeBase bb : BiomeBase.biomes)
		{
			if (bb == null) continue;
			ret.add(bb);
		}
		return ret;
	}
	
	public static void setBiomeId(CraftWorld craftWorld, int x, int z, int id) {
		BiomeBase bb = BiomeBase.biomes[id];
        if (craftWorld.loadChunk(x >> 4, z >> 4, false)) {
            net.minecraft.server.Chunk chunk = craftWorld.getHandle().getChunkAtWorldCoords(x, z);

            if (chunk != null) {
                byte[] biomevals = chunk.l();
                biomevals[((z & 0xF) << 4) | (x & 0xF)] = (byte)bb.id;
            }
        }
    }
	
	public static void getRawBiomeId(CraftWorld craftWorld, int x, int z)
	{
		
	}
}
