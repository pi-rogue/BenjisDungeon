package com.pirogue.entity.mob;

import com.pirogue.entity.Mob;
import com.pirogue.game.Constants;

public class Slime extends Mob {
	
	private String _color = "blue";

	public Slime(int x, int y, String color) {
		super(x, y);
		this.velocity = 0.25f; // La moitié de celle du héros
		this._color = color;
		refreshAnimations();
	}
	
	@Override
	protected void refreshAnimations() {
		restAnims = Constants.animations.get("slime rest " + _color);
		movingAnims = Constants.animations.get("slime moving " + _color);
		for (int n=0; n<restAnims.length; n++) movingAnims[n].setPingPong(true);
	}

	@Override
	protected void updateFacing() {
		facing = 0; // Il n'y a pas de direction pour les slimes
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
