package com.pirogue.entity.mob;

import org.newdawn.slick.Graphics;

import com.pirogue.entity.Mob;
import com.pirogue.game.Constants;
import com.pirogue.game.util.Animations;

public class Slime extends Mob {
	
	private String _color = "blue";
	private boolean attack = false;

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

		Animations attackAnims = Constants.animations.get("debug missing");
		attackAnims.setPlayOnce(); // Les animations des attaques ne doivent pas tourner en boucle
		animations.put("attack", attackAnims);
	}

	public void render(Graphics g, int offsetX, int offsetY) {
		if (attack) {
			Animations attackAnims = animations.get("attack");
			g.drawAnimation(attackAnims.get(facing), this.x-offsetX + (Constants.SCREEN_WIDTH-Constants.blockSize)/2, this.y-offsetY + (Constants.SCREEN_HEIGHT-Constants.blockSize)/2);
			if (attackAnims.get(facing).isStopped()) { // Quand l'animation est finie, on peut à nouveau attaquer, il faut alors reset les animations
				this.attack = false;
				attackAnims.restartAll(); 
			}
		}
		else
			super.render(g, offsetX, offsetY);
	}
	
	@Override
	public void attack() {
		this.attack = true;
	}
}
