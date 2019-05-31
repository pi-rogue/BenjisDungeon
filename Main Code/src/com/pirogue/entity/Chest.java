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
		this.facing = 0; // On ouvre le coffre dès qu'il prend des dégats
		// this.drop(); // en fonction de this.rarity
	}
}
