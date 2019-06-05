package com.pirogue.entity;

import com.pirogue.game.Constants;

public class Stairs extends Entity {
	public Stairs(int x, int y) {
		super(x, y);
		this.collisionsEnabled=false;
		refreshAnimations();
	}

	@Override
	protected void refreshAnimations() {
		this.animations.put("rest", Constants.animations.get("accessories stairs"));
	}

	@Override
	public void dealDamages() {}

	@Override
	public void hurt(int damages) {}
}
