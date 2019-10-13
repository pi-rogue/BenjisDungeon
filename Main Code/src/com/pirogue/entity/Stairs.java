package com.pirogue.entity;

import com.pirogue.game.Constants;

public class Stairs extends Entity {
	public int level=-1; // -1 pour un escalier descendant, +1 pour un montant 
	
	public Stairs(int x, int y) {
		super(x, y);
		refreshAnimations();
	}

	public Stairs(int x, int y, int level) {
		super(x, y);
		this.level = level;
		refreshAnimations();
	}
	
	@Override
	protected void refreshAnimations() {
		this.facing = this.level == -1 ? 0 : 1;
		this.animations.put("rest", Constants.animations.get("accessories stairs"));
	}

	@Override
	public void dealDamages() {}

	@Override
	public void hurt(int damages) {}

	@Override
	protected void updateFacing() {}
}
