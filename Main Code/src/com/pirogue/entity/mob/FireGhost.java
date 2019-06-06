package com.pirogue.entity.mob;

import org.newdawn.slick.Graphics;

import com.pirogue.entity.Mob;
import com.pirogue.entity.projectiles.Fireball;
import com.pirogue.game.Constants;

public class FireGhost extends Mob {

	private int attackCooldown = 0;

	public FireGhost(int x, int y) {
		super(x, y);
		this.velocity = Constants.fireGhostSpeed;
		this.aggro = Constants.fireGhostAggro;
		this.range = Constants.fireGhostRange;
		this.damages = 10;

		refreshAnimations();
	}

	public void render(Graphics g, int offsetX, int offsetY) {
		super.render(g, offsetX, offsetY, false, 0, 0);
	}
	
	@Override
	protected void refreshAnimations() {
		animations.put("rest", Constants.animations.get("mobs fire_ghost moving"));
		animations.put("moving", Constants.animations.get("mobs fire_ghost moving"));
		animations.put("hit rest", Constants.animations.get("mobs fire_ghost hit moving"));
		animations.put("hit moving", Constants.animations.get("mobs fire_ghost hit moving"));
	}

	@Override
	public void update(int delta) {
		attackCooldown++;
		super.update(delta);
	}

	@Override
	protected boolean aggro() {
		if(Math.sqrt(distX*distX+distY*distY)<aggro) { // Detecte si le mob est assez proche pour pathfind
			if(Math.sqrt(distX*distX+distY*distY)<range) { // Detecte si le mob est assez pres pour attaquer
				attack();
				return false;
			}
			return true;
		}
		return false;
	}

	
	@Override
	public void attack() {
		if (!this.isDead && this.attackCooldown > Constants.fireGhostCooldown) {
			attackCooldown = 0;
			float angle;
			int Xa = this.x;
			int Ya = this.y;
			int Xb = Constants.dungeon.hero.x;
			int Yb = Constants.dungeon.hero.y;
			angle = (float) (Math.acos((Xb-Xa)/Math.sqrt((Xb-Xa)*(Xb-Xa) + (Yb-Ya)*(Yb-Ya)))) * (Yb<Ya?-1:1); // Quick math (angle avec le héros par rapport à l'horizontale)
			Constants.dungeon.getCurrentFloor().entities.add(new Fireball(x, y, angle));
		}
	}

	@Override
	public void dealDamages() {}

	@Override
	protected void updateFacing() {
		switch (moving) {
		case 0: break;
		case 1: facing=0; break;
		case 2: facing=0; break;
		case 3: facing=0; break;
		case 4: break;
		case 5: facing=1; break;
		case 6: facing=1; break;
		case 7: facing=1; break;
		}
	}	
	
}
