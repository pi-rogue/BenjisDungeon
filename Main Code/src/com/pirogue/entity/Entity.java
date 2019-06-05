package com.pirogue.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.pirogue.game.Constants;
import com.pirogue.game.util.AnimationsContainer;

public abstract class Entity {

	public boolean collisionsEnabled=true;
	protected int distX=200, distY=200;
	public int x,y, width,height, ID;
	protected float velocity = 0.5f;
	protected int life = 100; // Pour l'instant c'est en pourcentage
	public int damages;
	protected int facing; // Direction de l'entité
	protected int moving = -1; // Direction du déplacement de l'entité (-1 si on ne se déplace pas)
	protected int attackID = -1; // -1 si aucune attaque n'est en cours, 0 pour la première attaque, etc
	protected int hitCounter=20;
	protected AnimationsContainer animations = new AnimationsContainer(); // Regroupe toutes les animations possibles de l'entité
	protected boolean isColliding = false; // True si l'entité est en collision avec un mur ou une autre entité
	protected boolean damageDealt; // Cette variable permet de n'infliger les dégâts qu'une seule fois 
	private boolean momentum = false; // True après un déplacement quand l'entité glisse un peu à vitesse réduite 
	public boolean isDead = false;
	public boolean vanished = false; // True quand l'animation de mort est terminée et l'entité est vraiment morte

	public Entity(int x, int y) {
		this.ID = Constants.newID();
		this.x = x*Constants.blockSize+Constants.blockSize/2;
		this.y = y*Constants.blockSize+Constants.blockSize/2;
		this.width = Constants.blockSize-2;  // On enlève 2 pour pouvoir passer tranquillement dans les couloirs de 1 bloc de largeur
		this.height = Constants.blockSize-2; //
		animations.put("rest", Constants.animations.get("debug default"));
		animations.put("moving", Constants.animations.get("debug default"));
	}
	
	public void render(Graphics g, int offsetX, int offsetY) {
		this.render(g, offsetX, offsetY, false, 0, 0);
	}

	public void render(Graphics g, int offsetX, int offsetY, boolean alwaysDrawBody, int attackOffsetX, int attackOffsetY) { 
		float X = this.x-offsetX + (Constants.SCREEN_WIDTH-Constants.blockSize)/2;  // Coordonnées du coin supérieur gauche (en considérant que l'entité a une longueur 
		float Y = this.y-offsetY + (Constants.SCREEN_HEIGHT-Constants.blockSize)/2; // et largeur d'une case entière et pas -2, ce qui permet de ne pas décaler l'image)
		// Affichage de la hitbox //
		if (Constants.debug) {
			g.setColor(new Color(1f, 1f, 1f));
			g.drawRect(this.x-offsetX +(Constants.SCREEN_WIDTH-this.width)/2 , this.y-offsetY +(Constants.SCREEN_HEIGHT-this.height)/2, this.width, this.height);
		}
		
		// Animation de mort //
		if (this.isDead) {
			g.drawAnimation(animations.get("death").get(0), X, Y);
			if (animations.get("death").get(0).isStopped()) {
				this.vanished = true;
			}
		}
		else {
			hitCounter++;
			
			// Affichage de l'attaque //
			if (attackID!=-1) {
				Animation attackAnim = animations.get("attack " + attackID).get(facing);
				g.drawAnimation(attackAnim, X-attackOffsetX, Y-attackOffsetY);
				if (hitCounter < 10 && !alwaysDrawBody) { // TODO: Clarifier cette condition
					Animation hitAttack = animations.get("hit attack " + attackID).get(facing);
					g.drawImage(hitAttack.getImage(attackAnim.getFrame()), X-attackOffsetX, Y-attackOffsetY);
				}
				if (attackAnim.isStopped()) { // Quand l'animation est finie, on peut à nouveau attaquer, il faut alors reset les animations
					attackAnim.restart();
					this.attackID = -1;
					this.damageDealt = false;
				}
			}
			// Affichage du corps //
			if (attackID==-1 || alwaysDrawBody) {
				String key = moving==-1 ? "rest" : "moving";
				Animation animBody = animations.get(key).get(facing);
				g.drawAnimation(animBody, X, Y);
				if (hitCounter < 10) {
					Animation hitBody = animations.get("hit " + key).get(facing);
					g.drawImage(hitBody.getImage(animBody.getFrame()), X, Y);
				}
			}
		}
	}
		
	public void update(int delta) {
		
		this.distX = this.x - Constants.dungeon.hero.x;//la distance qui separe le hero du mob en x
		this.distY = this.y - Constants.dungeon.hero.y;//pareil en y
		
		// Check if the entity is dead //
		if (this.life <= 0) {
			this.isDead  = true;
			this.attackID = -1;
			return;
		}
		
		// Check if we have to deal damages //
		if (attackID!=-1 && animations.get("attack " + attackID).get(facing).getFrame() == animations.get("attack " + attackID).getDamageFrame()) {
			if (!damageDealt) {
				dealDamages();
				damageDealt = true;
			}
		}
		
		// Update facing //
		if (attackID==-1) { // Quand on attaque on ne peut pas changer de direction
			updateFacing();
		}
		
		// Update position //
		if (moving!=-1) {
			int futureX = x;
			int futureY = y;
			int movement = Constants.randomRound(velocity * delta * (momentum ? 0.5f : 1f)); // Calcul du déplacement, en réduisant la vitesse si l'entité est entrain de glisser

			switch (moving) {
			case 0:	futureY -= movement; break;  // N
			case 2:	futureX += movement; break;  // E
			case 4:	futureY += movement; break;  // S
			case 6:	futureX -= movement; break;  // O
			case 1:	futureX += Constants.randomRound(movement * 0.707f); futureY -= Constants.randomRound(movement * 0.707f); break;  // NE
			case 3:	futureX += Constants.randomRound(movement * 0.707f); futureY += Constants.randomRound(movement * 0.707f); break;  // SE
			case 5:	futureX -= Constants.randomRound(movement * 0.707f); futureY += Constants.randomRound(movement * 0.707f); break;  // SO
			case 7:	futureX -= Constants.randomRound(movement * 0.707f); futureY -= Constants.randomRound(movement * 0.707f); break;  // NO
			}

			// Si on sort de la map ben en fait non (au cas où)
			if (futureX<0) futureX=0;
			if (futureY<0) futureY=0;
			if (futureX>Constants.mapWidth*Constants.blockSize-width) futureX=Constants.mapWidth*Constants.blockSize-width;
			if (futureY>Constants.mapHeight*Constants.blockSize-height) futureY=Constants.mapHeight*Constants.blockSize-height;

			// Vérification des collisions
			// On numérote les quatres coins de l'entitée comme ça:
			// 0 | 1
			// -----
			// 2 | 3
			boolean[] corners = {false, false, false, false}; // Liste des coins à checker

			switch (moving) { // Pour alléger on ne check que certains coins selon la direction (3 coins pour un déplacement diagonal, 2 sinon)
			case 0: corners[0]=true; corners[1]=true; break;
			case 1: corners[0]=true; corners[1]=true; corners[3]=true; break;
			case 2: corners[1]=true; corners[3]=true; break;
			case 3: corners[1]=true; corners[3]=true; corners[2]=true; break;
			case 4: corners[3]=true; corners[2]=true; break;
			case 5: corners[3]=true; corners[2]=true; corners[0]=true; break;
			case 6: corners[2]=true; corners[0]=true; break;
			case 7: corners[2]=true; corners[0]=true; corners[1]=true; break;
			}

			if (isColliding(corners, futureX, futureY)) {
				switch (moving) { // Quand on se déplace en diagonale on peut quand meme peut-être glisser sur un mur
                case 1: // Diagonnale haut droite
                    if (!isColliding(corners, this.x + movement, this.y)) // En déplacant vers 'E' au lieu de 'NE'  
                    	this.x = Constants.randomRound(this.x + movement);
                    else if (!isColliding(corners, this.x, this.y - movement))   // En déplacant vers 'N' au lieu de 'NE'
                    	this.y = Constants.randomRound(this.y - movement);
                    break;
                case 3: // Diagonnale bas droite
                    if (!isColliding(corners, this.x + movement, this.y))  // En déplacant vers 'E' au lieu de 'SE'
                    	this.x = Constants.randomRound(this.x + movement);
                    else if (!isColliding(corners, this.x, this.y + movement))  // En déplacant vers 'S' au lieu de 'SE'
                    	this.y = Constants.randomRound(this.y + movement);
                    break;
                case 5: // Diagonnale bas gauche
                    if (!isColliding(corners, this.x - movement, this.y))  // En déplacant vers 'O' au lieu de 'SO'
                    	this.x = Constants.randomRound(this.x - movement);
                    else if (!isColliding(corners, this.x, this.y + movement))  // En déplacant vers 'S' au lieu de 'SO'
                    	this.y = Constants.randomRound(this.y + movement);
                    break;
                case 7: // Diagonnale haut gauche
                    if (!isColliding(corners, this.x - movement, this.y))  // En déplacant vers 'O' au lieu de 'NO'
                    	this.x = Constants.randomRound(this.x - movement);
                    else if (!isColliding(corners, this.x, this.y - movement))  // En déplacant vers 'N' au lieu de 'NO'
                    	this.y = Constants.randomRound(this.y - movement);
                    break;
                }
			}
			else { // Si il n'y a pas de collision alors aucun problème
				this.x = futureX;
				this.y = futureY;
			}
		}
	}

	private boolean isColliding(boolean[] corners, int futureX, int futureY) {
		Image img;
		int cornerX=0, cornerY=0;
		
		for (int i=0; i<4; i++) { // Pour chaque coin
			if (corners[i]) { // Si c'est un coin à checker
				// Selon le coin on récupère ses coordonnées
				switch (i) {
				case 0:
					cornerX = futureX-width/2;
					cornerY = futureY-height/2;
					break;
				case 1:
					cornerX = futureX+width/2;
					cornerY = futureY-height/2;
					break;
				case 2:
					cornerX = futureX-width/2;
					cornerY = futureY+height/2;
					break;
				case 3:
					cornerX = futureX+width/2;
					cornerY = futureY+height/2;
					break;
				}
				
				
				// --- Colliisons avec les murs --- //
				// On récupère l'image de collision de la Tile sur laquelle se trouve le coin 
				img = Constants.dungeon.getCurrentFloor().getCollideImage((int)(cornerX/Constants.blockSize), (int)(cornerY/Constants.blockSize));
				if (img != null) {
					// On récupère la couleur du pixel sur lequel se trouve le coin
					Color color = img.getColor((int)(cornerX % Constants.blockSize), (int)(cornerY % Constants.blockSize));
					if (color.getRed()==255 && color.getGreen()==0 && color.getBlue()==0) {
						isColliding = true;
						return true; // Si c'est du rouge alors il y a collision
					}
				}
				else {isColliding = true; return true;} // Si l'image est null (pour du vide par exemple), on ne peut pas marcher dessus
			}
		}

		// --- Collisions avec les autres entités --- //
		// Pour l'instant solution de la facilité : on interdit la distance avec les autres entités à être < à blockSize
		for (Entity ent : Constants.dungeon.getCurrentFloor().entities) {
			if (ent.ID!=this.ID && ent.collisionsEnabled && Math.sqrt(Math.pow(ent.x-futureX, 2)+Math.pow(ent.y-futureY, 2))<Constants.blockSize) {
				return true;
			}
		}
		if (this instanceof Mob) { // Les mobs doivent aussi vérifier les coords du héros
			if (Math.sqrt(Math.pow(Constants.dungeon.hero.x-futureX, 2)+Math.pow(Constants.dungeon.hero.y-futureY, 2))<Constants.blockSize) {
				return true;
			}
		}

		return false;
	}

	public void setFacing(int facing) {
		this.facing = facing;
	}

	public void setMoving(int moving) {
		this.moving = moving;
	}
	
	public void setMomentum(boolean momentum) {
		this.momentum = momentum;
	}
	
	public void setLife(int x) {
		this.life = x;
	}
	
	protected abstract void refreshAnimations();
	protected abstract void updateFacing();
	public abstract void dealDamages();
	public abstract void hurt(int damages);

}
