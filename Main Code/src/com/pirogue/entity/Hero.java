package com.pirogue.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.pirogue.game.Constants;
import com.pirogue.game.Inventory;
import com.pirogue.game.util.Animation;

public abstract class Hero extends Entity {
	
	public Inventory inventory;
	private String _class;
	private Animation[][] equipmentAnims; // animations de tous les équipements (contient tous les 'calques')
	private Animation[][] inventoryAnims; // animations à afficher dans l'inventaire (en gros c'est juste une copie de equipmentAnims en plus grand)
	private Animation[] attackAnims; // animations de l'attaque (quand on aura plusieurs attaques il faudra ajouter une dimention au tableau ou faire plusieurs variables genre 'autoAnims', 'ultiAnims', etc)
	private boolean isAttacking = false;
	
	public Hero(int x, int y, String _class) throws SlickException {
		super(x, y);
		this._class = _class;
		this.inventory = new Inventory();
		refreshAnimations();
	}
	
	public void render(Graphics g) {
		super.render(g, x+1, y+1);
		for (int n=0; n<equipmentAnims.length; n++) {
			if (isAttacking && inventory.objects[n].type.equals("weapon")) {
				g.drawAnimation(attackAnims[facing], (Constants.SCREEN_WIDTH-Constants.blockSize)/2 - (facing==1 ? Constants.blockSize:0), (Constants.SCREEN_HEIGHT-Constants.blockSize)/2);
				if (attackAnims[facing].isStopped()) {
					isAttacking = false;
					for (int i=0; i<attackAnims.length; i++) attackAnims[i].restart();;
				}
			}
			else
				g.drawAnimation(equipmentAnims[n][facing], (Constants.SCREEN_WIDTH-Constants.blockSize)/2, (Constants.SCREEN_HEIGHT-Constants.blockSize)/2);
		}
		if (inventory.isVisible()) {
			inventory.render(g, inventoryAnims, facing);
		}
	}

	protected void refreshAnimations() {
		// Cette fonction remplit toutes les variables suivantes avec les animations adéquates en fonction de l'équipement du héros
		inventoryAnims = new Animation[7][];
		equipmentAnims = new Animation[6][];
		restAnims = Constants.animations.get(_class);
		movingAnims = Constants.animations.get(_class);
		attackAnims = Constants.animations.get("attack " + inventory.objects[5].getAcces()); // inventory.equipment[5] correspond à l'arme dans la main droite (voir Inventory.java lignes 93 - 98)
		for (int n=0; n<attackAnims.length; n++) attackAnims[n].stopAt(attackAnims[n].getFrameCount()-1);
		
		// inventory[0] Contient les animations du héros en agrandi
		Animation[] tmp = new Animation[restAnims.length];
		for (int n=0; n<restAnims.length; n++) {
			tmp[n] = restAnims[n].getScaledCopy(inventory.getHeroCell().getWidth(), inventory.getHeroCell().getHeight());
		}
		inventoryAnims[0] = tmp;
		
		// --- //
		for (int i=0; i<6; i++) {
			Animation[] originalAnims = Constants.animations.get("equipment " + inventory.objects[i].getAcces());
			tmp = new Animation[originalAnims.length];
			for (int n=0; n<originalAnims.length; n++) {
				tmp[n] = originalAnims[n].getScaledCopy(inventory.getHeroCell().getWidth(), inventory.getHeroCell().getHeight());
			}
			equipmentAnims[i] = originalAnims;
			inventoryAnims[i+1] = tmp; 
		}
	}
	
	public void update(GameContainer container, int delta) {
		super.update(container, delta);
		if (this.inInventory()) {
			if (inventory.update()) refreshAnimations();
		}
	}
	
	protected void updateFacing() {
		
		if (Constants.mouseX > Constants.SCREEN_WIDTH/2) facing=0;
		else facing=1;
		
		/*
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
		*/
	}
	
	public void toggleInventory() {
		if (inventory.isVisible()) {
			// Drop inventory.selectedItem
		}
		inventory.setVisible(!inventory.isVisible());
	}
	
	public boolean inInventory() {
		return inventory.isVisible();
	}

	public void attack() {
		this.isAttacking = true;		
	}
}
