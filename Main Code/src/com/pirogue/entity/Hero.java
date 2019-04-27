package com.pirogue.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.pirogue.game.Constants;
import com.pirogue.game.Inventory;

public abstract class Hero extends Entity {
	
	protected Inventory inventory;
	private String _class;
	private Animation[] inventoryAnims;
	
	public Hero(int x, int y, String _class) throws SlickException {
		super(x, y);
		this._class = _class;
		this.inventory = new Inventory();
		refreshAnimations();
	}
	
	public void render(Graphics g) {
		if (inventory.isVisible()) {
			inventory.render(g);
			Rectangle cell = inventory.getHeroCell();
			g.drawAnimation(inventoryAnims[facing], cell.getMinX(), cell.getMinY());
		}
		else
			super.render(g, x+Constants.blockSize/2, y+Constants.blockSize/2);
	}

	protected void refreshAnimations() {
		restAnims = Constants.animations.get(_class + " rest " + inventory.getEquipment());
		movingAnims = Constants.animations.get(_class + " moving " + inventory.getEquipment());
		inventoryAnims = new Animation[restAnims.length];
		
		for (int n=0; n<inventoryAnims.length; n++) {
			Animation anim = new Animation();
			for (int i=0; i<restAnims[n].getFrameCount(); i++) {
				anim.addFrame(restAnims[n].getImage(i).getScaledCopy((int)inventory.getHeroCell().getWidth(), (int)inventory.getHeroCell().getHeight()), restAnims[n].getDuration(i));
			}
			inventoryAnims[n] = anim;
		}
	}
	
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
	
	public void toggleInventory() {
		inventory.setVisible(!inventory.isVisible());
	}
	
	public boolean inInventory() {
		return inventory.isVisible();
	}
}
