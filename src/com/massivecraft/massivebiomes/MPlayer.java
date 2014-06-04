package com.massivecraft.massivebiomes;

import com.massivecraft.massivecore.store.SenderEntity;

public class MPlayer extends SenderEntity<MPlayer>
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	protected int x1 = 0;
	public int getX1() { return this.x1; }
	public void setX1(int val) { this.x1 = val; }
	
	protected int x2 = 0;
	public int getX2() { return this.x2; }
	public void setX2(int val) { this.x2 = val; }
	
	protected int z1 = 0;
	public int getZ1() { return this.z1; }
	public void setZ1(int val) { this.z1 = val; }
	
	protected int z2 = 0;
	public int getZ2() { return this.z2; }
	public void setZ2(int val) { this.z2 = val; }
	
	// MINMAX
	public int getXMin() { return Math.min(x1, x2); }
	public int getXMax() { return Math.max(x1, x2); }
	public int getZMin() { return Math.min(z1, z2); }
	public int getZMax() { return Math.max(z1, z2); }
	
}
