package com.pirogue.entity.mob;

import org.newdawn.slick.Graphics;

import com.pirogue.entity.Mob;
import com.pirogue.game.Constants;
import com.pirogue.game.util.Animations;

public class FireGhost extends Mob {

	public FireGhost(int x, int y) {
		super(x, y);
		this.velocity = Constants.slimeSpeed;
		this.aggro = Constants.slimeAggro;
		this.range = Constants.slimeRange;
		this.facing = 0;
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
		animations.put("hit attack 0", Constants.animations.get("mobs fire_ghost hit moving"));
		
		/* Les animations d'attaque et de mort doivent être propre à chaque mob */
		Animations tmp = new Animations(Constants.animations.get("mobs fire_ghost moving"));
		tmp.setPlayOnce();
		animations.put("attack 0", tmp);
		animations.put("death", tmp);
	}

	@Override
	public void attack() {
		if (!this.isDead) {
			this.attackID = 0;
		}
	}

	@Override
	public void dealDamages() {
		if (Math.sqrt(Math.pow(Constants.dungeon.hero.x-this.x, 2)+Math.pow(Constants.dungeon.hero.y-this.y, 2))<Constants.blockSize*1.5f) {
			Constants.dungeon.hero.hurt(this.damages);
		}
	}

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
