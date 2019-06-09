package com.pirogue.entity;

import com.pirogue.game.Constants;

public class Chest extends Entity {

	public String rarity;
	public boolean opened = false; //test pour le drop si le coffre est ouvert.

	public Chest(int x, int y, String rarity) {
		super(x, y);
		this.rarity = rarity;
		this.life = 1;
		this.facing = 1;
		refreshAnimations();
	}

	@Override
	protected void refreshAnimations() {
		this.animations.put("rest", Constants.animations.get("accessories chest"));
	}

	@Override
	public void dealDamages() {}

	@Override
	public void hurt(int damages) {
		this.life = 0;
		this.facing = 0;
		this.collisionsEnabled=false;
	}

	public void update(int delta) {
		if(this.life==0 && !this.opened) {
			this.drop();
			this.opened = true;
		}
	}
	
	@Override
	protected void updateFacing() {}

	public void drop() {
		for (int i=0;i<6;i++) {
		int randomx = -100 + (int) (Math.random() * 200);
		int randomy = -100 + (int) (Math.random() * 200);
		Constants.dungeon.getCurrentFloor().entities.add(new Loot(this.x+randomx,this.y+randomy));
		
		
		
		
		
		
	}}}