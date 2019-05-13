package com.pirogue.entity.mob;

import com.pirogue.entity.Mob;
import com.pirogue.game.Constants;
import com.pirogue.game.util.Animations;

public class Slime extends Mob {
	
	private String _color = "blue";

	public Slime(int x, int y, String color) {
		super(x, y);
		this.velocity = 0.15f; 
		this._color = color;
		this.facing = 0; // Il n'y a pas de direction pour les slimes
		refreshAnimations();
	}
	
	@Override
	protected void refreshAnimations() {
		animations.put("rest", Constants.animations.get("mobs slime rest " + _color));
		Animations movingAnims = Constants.animations.get("mobs slime moving " + _color);
		movingAnims.setPingPong();
		animations.put("moving", movingAnims);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
