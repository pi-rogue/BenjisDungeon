package com.pirogue.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.pirogue.game.Constants;
import com.pirogue.game.Inventory;
import com.pirogue.game.util.Animations;
import com.pirogue.items.EmptyItem;

public abstract class Hero extends Entity {

	private Image[] lifeBar = new Image[3];
	private String[] equipmentKeys = {"head", "chestplate", "legs", "foots", "left hand", "right hand"};
	public Inventory inventory;
	private String _class; // Classe du héros
	
	public Hero(int x, int y, String _class) throws SlickException {
		super(x, y);
		this._class = _class;
		this.inventory = new Inventory();
		this.damages = 25; 
		
		SpriteSheet spr = new SpriteSheet("src/assets/gui/life_bar.png", 148, 31);
		this.lifeBar[0] = spr.getSprite(0, 0); // Cadre
		this.lifeBar[1] = spr.getSprite(0, 1); // Fond
		this.lifeBar[2] = spr.getSprite(0, 2); // Vie
		
		refreshAnimations();
	}
	
	public void render(Graphics g) {
		// Affichage de la barre de vie //
		g.drawImage(lifeBar[1], 40, Constants.SCREEN_HEIGHT-50); // Fond
		g.drawImage(lifeBar[2].getScaledCopy(lifeBar[0].getWidth()*this.life/100, lifeBar[0].getHeight()), 40, Constants.SCREEN_HEIGHT-50); // Vie
		g.drawImage(lifeBar[0], 40, Constants.SCREEN_HEIGHT-50); // Cadre
		
		// Affichage du héros //
		super.render(g, x, y, true, (facing==1?Constants.blockSize:0), 0);
		
		// Affichage des équipements //
		int cornerX = (Constants.SCREEN_WIDTH-Constants.blockSize)/2;
		int cornerY = (Constants.SCREEN_HEIGHT-Constants.blockSize)/2;
		for (String key : equipmentKeys) {
			if (attackID==-1 || !key.matches(".* hand")) { // TODO: Gérer les deux mains (en alternent entre chaque arme ?)
				g.drawAnimation(animations.get(key).get(facing), cornerX, cornerY);
			}
		}

		// Affichage de l'inventaire //
		if (inventory.isVisible()) {
			inventory.render(g, facing, animations.get("inventory body"),
										animations.get("inventory head"),
										animations.get("inventory chestplate"),
										animations.get("inventory legs"),
										animations.get("inventory foots"),
										animations.get("inventory left hand"),
										animations.get("inventory right hand"));
		}
	}

	protected void refreshAnimations() {
		/* 
		 * Cette fonction remplit l'AnimationsContainer avec les animations dont on aura
		 * besoin en fonction de l'équipement du héros.
		 */
		animations.put("death", Constants.animations.get("debug missing")); // Animations quand le héros se déplace
		animations.put("rest", Constants.animations.get("heroes " + _class)); // Animations quand le héros ne se déplace pas
		animations.put("moving", Constants.animations.get("heroes " + _class)); // Animations quand le héros se déplace
		animations.put("hit rest", Constants.animations.get("heroes hit")); 
		animations.put("hit moving", Constants.animations.get("heroes hit"));
		animations.put("attack 0", new Animations(Constants.animations.get("heroes attack auto " + inventory.objects[5].getAcces()))); // inventory.equipment[5] correspond à l'arme dans la main droite (voir Inventory.java))
		attackID = -1; // Si jamais on change d'arme pendant une attaque, on arrête l'attaque

		float invCellWidth = inventory.getHeroCell().getWidth();   // Largeur et hauteur de la case pour afficher le héros dans l'inventaire. 
		float invCellHeight = inventory.getHeroCell().getHeight(); // On doit agrandir les animations pour qu'elles rentrent dans cette case
		for (int i=0; i<6; i++) {
			animations.put(equipmentKeys[i], Constants.animations.get("heroes equipment " + inventory.objects[i].getAcces()));
			animations.put("inventory " + equipmentKeys[i], Constants.animations.get("heroes equipment " + inventory.objects[i].getAcces()).getScaledCopy(invCellWidth, invCellHeight)); // Agrandissement
		}
		animations.put("inventory body", animations.get("rest").getScaledCopy(invCellWidth, invCellHeight));
	}
	
	public void update(int delta) {					
		super.update(delta);
		if (isDead) this.life=0; // Permet de ne pas avoir de vie négative (pour la barre de vie)
		if (attackID==-1) updateFacing(); // Quand on attaque on ne peut pas changer de direction
		if (inInventory()) {
			if (inventory.update())	refreshAnimations(); // inventory.update() renvoie true si jamais les équipements ont été modifiés
		}
		else {
			if (Constants.mousePressed && !Constants.mouseWasPressed) attack(); // TODO: Changer la condition si on veut pouvoir laisser appuyé pour attaquer
		}
	}
	
	protected void updateFacing() {		
		if (Constants.mouseX > Constants.SCREEN_WIDTH/2) // Facing dépend de la souris
			facing=0;
		else 
			facing=1;
		
		/* Ancien code pour update facing avec les déplacements
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
		inventory.setVisible(!inventory.isVisible());
		refreshAnimations(); // Permet de prévenir un bug d'affichage si on quitte l'inventaire en tenant un objet avec la souris
	}
	
	public boolean inInventory() {
		return inventory.isVisible();
	}

	public void attack() {
		if (!inInventory() && !(inventory.objects[5] instanceof EmptyItem))	this.attackID = 0;		
	}
	
	public void hurt(int damages) {
		this.life -= damages; // TODO: prendre en compte l'armure
		this.hitCounter = 0;
	}
	
	public void dealDamages() { // TODO: prendre en compte les dégâts de l'arme, et changer la range en fonction du sort, donc déplacer cette méthode dans chaque classe ?
		for (Entity ent : Constants.dungeon.getCurrentFloor().entities) {
			if (ent.x>this.x && facing==0 && Math.sqrt(Math.pow(ent.x-this.x, 2)+Math.pow(ent.y-this.y, 2))<Constants.blockSize*1.5f)
					ent.hurt(damages);
			else if (ent.x<this.x && facing==1 && Math.sqrt(Math.pow(ent.x-this.x, 2)+Math.pow(ent.y-this.y, 2))<Constants.blockSize*1.5f)
					ent.hurt(damages);
		}
	}
}
