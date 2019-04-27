package com.pirogue.entity.mob;

import com.pirogue.entity.Mob;
import com.pirogue.game.Constants;

public class Slime extends Mob {
	
	private String _color = "blue";

	public Slime(int x, int y, String color) {
		super(x, y);
		this._color = color;
		refreshAnimations();
	}
	
	@Override
	protected void refreshAnimations() {
		restAnims = Constants.animations.get("slime rest " + _color);
		movingAnims = Constants.animations.get("slime moving " + _color);
	}

	@Override
	protected void updateFacing() {
		facing = 0; // Il n'y a pas de direction pour les slimes
	}
	
	@Override
	public void pathfind() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aggro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
