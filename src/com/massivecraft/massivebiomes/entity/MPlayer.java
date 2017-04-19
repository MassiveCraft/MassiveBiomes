package com.massivecraft.massivebiomes.entity;

import com.massivecraft.massivebiomes.SelectionPosition;
import com.massivecraft.massivecore.store.SenderEntity;

import static com.massivecraft.massivebiomes.SelectionPosition.FIRST;
import static com.massivecraft.massivebiomes.SelectionPosition.SECOND;

public class MPlayer extends SenderEntity<MPlayer>
{
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public boolean isDefault()
	{
		// Always default => never save
		return true;
	}
	
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	protected int x1 = 0;
	public int getX1() { return this.x1; }
	public void setX1(int val) { this.x1 = val; this.changed(); }
	
	protected int x2 = 0;
	public int getX2() { return this.x2; }
	public void setX2(int val) { this.x2 = val; this.changed(); }
	
	protected int z1 = 0;
	public int getZ1() { return this.z1; }
	public void setZ1(int val) { this.z1 = val; this.changed(); }
	
	protected int z2 = 0;
	public int getZ2() { return this.z2; }
	public void setZ2(int val) { this.z2 = val; this.changed(); }
	
	public void setX(int val, SelectionPosition selectionPosition)
	{
		if (selectionPosition == FIRST) this.x1 = val;
		else if (selectionPosition == SECOND) this.x2 = val;
		else throw new IllegalArgumentException(String.format("SelectionPosition %s could not be processed", selectionPosition.name()));
		this.changed();
	}
	
	public int getX(SelectionPosition selectionPosition)
	{
		if (selectionPosition == FIRST) return this.x1;
		else if (selectionPosition == SECOND) return this.x2;
		else throw new IllegalArgumentException(String.format("SelectionPosition %s could not be processed", selectionPosition.name()));
	}
	
	public void setZ(int val, SelectionPosition selectionPosition)
	{
		if (selectionPosition == FIRST) this.z1 = val;
		else if (selectionPosition == SECOND) this.z2 = val;
		else throw new IllegalArgumentException(String.format("SelectionPosition %s could not be processed", selectionPosition.name()));
		this.changed();
	}
	
	public int getZ(SelectionPosition selectionPosition)
	{
		if (selectionPosition == FIRST) return this.z1;
		else if (selectionPosition == SECOND) return this.z2;
		else throw new IllegalArgumentException(String.format("SelectionPosition %s could not be processed", selectionPosition.name()));
	}
	
	// MINMAX
	public int getXMin() { return Math.min(x1, x2); }
	public int getXMax() { return Math.max(x1, x2); }
	public int getZMin() { return Math.min(z1, z2); }
	public int getZMax() { return Math.max(z1, z2); }
	
}
