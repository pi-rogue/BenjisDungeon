package com.pirogue.entity;

public abstract class Mob extends Entity {
	
	public Mob(int x, int y) {
		super(x, y);
	}
	
	public abstract void pathfind();
	public abstract void aggro();
	public abstract void attack();
}
