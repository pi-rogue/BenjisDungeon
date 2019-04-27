package com.pirogue.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.pirogue.game.Animation;
import com.pirogue.game.Constants;
import com.pirogue.game.Inventory;
import com.pirogue.items.Item;

public abstract class Hero extends Entity {
	
	protected Inventory inventory;
	private String _class;
	private Animation[][] inventoryAnims;
	
	public Hero(int x, int y, String _class) throws SlickException {
		super(x, y);
		this._class = _class;
		this.inventory = new Inventory();
		refreshAnimations();
	}
	
	public void render(Graphics g) {
		super.render(g, x, y);
		for (Item item : inventory.equipment) {
			g.drawAnimation(item.getAnimation()[facing], (Constants.SCREEN_WIDTH-Constants.blockSize)/2, (Constants.SCREEN_HEIGHT-Constants.blockSize)/2);
		}
		if (inventory.isVisible()) {
			inventory.render(g);
			Rectangle cell = inventory.getHeroCell();
			for (Animation[] animation : inventoryAnims) {
				g.drawAnimation(animation[facing], cell.getMinX(), cell.getMinY());
			}
		}
	}

	protected void refreshAnimations() {
		restAnims = Constants.animations.get(_class + " body");
		movingAnims = Constants.animations.get(_class + " body");
		inventoryAnims = new Animation[7][restAnims.length];
		
		Animation[] anims = new Animation[restAnims.length];
		for (int n=0; n<restAnims.length; n++) {
			anims[n] = restAnims[n].getScaledCopy(inventory.getHeroCell().getWidth(), inventory.getHeroCell().getHeight());
		}
		inventoryAnims[0] = anims;
		
		for (int i=0; i<6; i++) {
			Animation[] originalAnims = inventory.equipment[i].getAnimation();
			anims = new Animation[originalAnims.length];
			for (int n=0; n<originalAnims.length; n++) {
				anims[n] = originalAnims[n].getScaledCopy(inventory.getHeroCell().getWidth(), inventory.getHeroCell().getHeight());
			}
			inventoryAnims[i+1] = anims; 
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
