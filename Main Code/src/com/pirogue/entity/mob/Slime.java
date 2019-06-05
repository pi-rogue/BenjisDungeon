package com.pirogue.entity.mob;

import org.newdawn.slick.Graphics;

import com.pirogue.entity.Mob;
import com.pirogue.game.Constants;
import com.pirogue.game.util.Animations;

public class Slime extends Mob {

	private String _color;

	public Slime(int x, int y, String color) {
		super(x, y);
		this.velocity = Constants.slimeSpeed;
		this.aggro = Constants.slimeAggro;
		this.range = Constants.slimeRange;
		this._color = color;
		this.damages = 10;

		refreshAnimations();
	}
	
	@Override
	public void render(Graphics g, int offsetX, int offsetY) {
		super.render(g, offsetX, offsetY, false, Constants.blockSize, Constants.blockSize);
	}
	
	@Override
	protected void refreshAnimations() {
		animations.put("rest", Constants.animations.get("mobs slime rest " + _color));
		animations.put("moving", Constants.animations.get("mobs slime moving " + _color));
		animations.put("hit rest", Constants.animations.get("mobs slime hit rest"));
		animations.put("hit moving", Constants.animations.get("mobs slime hit moving"));
		animations.put("hit attack 0", Constants.animations.get("mobs slime hit attack"));
		
		/* Les animations d'attaque et de mort doivent être propre à chaque mob */
		animations.put("attack 0", new Animations(Constants.animations.get("mobs slime attack " + _color)));
		animations.put("death", new Animations(Constants.animations.get("mobs slime death " + _color)));
	}

	@Override
	public void attack() {
		if (!this.isDead) {
			this.attackID = 0;
		}
	}

	@Override
	public void updateFacing() {
		this.facing=0;
	}
	
	@Override
	public void dealDamages() {
		if (Math.sqrt(Math.pow(Constants.dungeon.hero.x-this.x, 2)+Math.pow(Constants.dungeon.hero.y-this.y, 2))<Constants.blockSize*1.5f) {
			Constants.dungeon.hero.hurt(this.damages);
		}
	}	
	
}
