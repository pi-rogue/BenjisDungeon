package com.pirogue.entity;

import com.pirogue.game.Constants;

public class Chest extends Entity {

	public String rarity;

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
		this.collisionsEnabled=false;
		// this.drop(); // TODO : Drop en fonction de this.rarity
	}

	@Override
	protected void updateFacing() {
		this.facing = this.life; // De cette façon le coffre s'ouvre quand on le frappe
	}
}
