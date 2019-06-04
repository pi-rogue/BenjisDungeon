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
		this.facing = 0; // Il n'y a pas de direction pour les slimes
		this.damages = 10;

		refreshAnimations();
	}

	@Override
	protected void refreshAnimations() {
		animations.put("rest", Constants.animations.get("mobs slime rest " + _color));
		Animations movingAnims = Constants.animations.get("mobs slime moving " + _color);
		movingAnims.setPingPong();
		animations.put("moving", movingAnims);

		Animations attackAnims = Constants.animations.get("mobs slime attack " + _color);
		attackAnims.setPlayOnce(); // Les animations des attaques ne doivent pas tourner en boucle
		animations.put("attack 0", attackAnims);
	}

	public void render(Graphics g, int offsetX, int offsetY) {
		if (attackID!=-1) {
			Animations attackAnims = animations.get("attack 0");
			g.drawAnimation(attackAnims.get(facing), this.x-offsetX + (Constants.SCREEN_WIDTH-Constants.blockSize)/2 - Constants.blockSize, this.y-offsetY + (Constants.SCREEN_HEIGHT-Constants.blockSize)/2 - Constants.blockSize);
			if (attackAnims.get(facing).isStopped()) { // Quand l'animation est finie, on peut à nouveau attaquer, il faut alors reset les animations
				this.attackID = -1;
				this.damageDealt = false;
				attackAnims.restartAll();
			}
		}
		else
			super.render(g, offsetX, offsetY);
	}

	@Override
	public void attack() {
		this.attackID = 0;
	}

	@Override
	public void dealDamages() {
		if (Math.sqrt(Math.pow(Constants.dungeon.hero.x-this.x, 2)+Math.pow(Constants.dungeon.hero.y-this.y, 2))<Constants.blockSize*2) {
			Constants.dungeon.hero.hurt(this.damages);
		}
	}

	@Override
	public void hurt(int damages) {
		this.life -= damages; // TODO: prendre en compte l'armure
	}
	
	
}
