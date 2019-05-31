package com.pirogue.game.util;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class Animations {
/* 
 * Dans notre jeu on gère les animations d'une manière groupée, parce que pour chaque chose que l'on veut animer
 * il faut prévoir une animation par direction. Afin de simplifier le code, la classe Animations (le s à la
 * fin est important) regroupe donc toutes les animations pour chaque direction. Une spritesheet est chargée selon
 * le schéma suivant:
 * Soit un sprite avec n directions de personnages (on espère en avoir plus de 2 un jour...) et p frames.
 * 
 *         C1   C2   ..   Cp
 *       ---------------------
 *       |    |    |    |    |
 *  L1   |    Animation 1    |
 *       |    |    |    |    |
 *       ---------------------
 *   .   |    |    |    |    |
 *   .   |    |  .....  |    |
 *   .   |    |    |    |    |
 *       ---------------------
 *       |    |    |    |    |
 *  Ln   |    Animation n    |
 *       |    |    |    |    |
 *       ---------------------
 * 
 * Le tableau d'animations correspondant aura donc n animations à p frames.
 * Si p=1 cela ne pose pas de problèmes, une seule image sera alors affichée, c'est pour cette raison
 * que l'on peut charger un sprite comme 'assets/sprites/heroes/equipment/bloody_daggers.png' de la même façon
 * que 'assets/sprites/heroes/equipment/basic_daggers.png' et surtout l'afficher de la même manière.
 * 
 * On ajoute en plus de cela une information contenue dans this.damageFrame qui correspond à la frame à laquelle 
 * on doit infliger des dégâts, car cette information dépend de l'animation (valable uniquement pour les animations
 * d'attaque). Par exemple pour l'attaque des slimes damageFrame=5, pour l'attaque des basic_daggers damageFrame=3
 * (attention la première frame est la frame 0).
 */
	
	private Animation[] anims;
	private int damageFrame=0;

	public Animations(Animation[] anims) {
		this.anims = anims;
	}

	public Animations(SpriteSheet spritesheet, int duration, int damageFrame) {
		this.damageFrame = damageFrame;
		anims = new Animation[spritesheet.getVerticalCount()]; // Une animation par ligne de spritesheet
		for (int y=0; y<spritesheet.getVerticalCount(); y++) {
			anims[y] = new Animation(spritesheet, 0, y, spritesheet.getHorizontalCount()-1, y, true, duration, true);
		}
	}
	
	public Animations getScaledCopy(float width, float height) {
		/* Retourne un nouvel objet Animations où chaque animations est redimentionnée à la bonne taille. */
		Animation[] newAnims = new Animation[anims.length];

		for (int j=0; j<anims.length; j++) {
			newAnims[j] = new Animation();
			for (int i=0; i<anims[j].getFrameCount(); i++) {
				newAnims[j].addFrame(anims[j].getImage(i).getScaledCopy((int)width, (int)height), anims[j].getDuration(i));
			}
		}
		return new Animations(newAnims);
	}
	
	public Animation get(int index) {
		return anims[index];
	}
	
	public void setPlayOnce() {
		for (int n=0; n<anims.length; n++)
			anims[n].stopAt(anims[n].getFrameCount()-1);
	}
	
	public void setPingPong() {
		for (int n=0; n<anims.length; n++)
			anims[n].setPingPong(true);
	}
	
	public int getDamageFrame() {
		return damageFrame;
	}
	
	public void restartAll() {
		for (int i=0; i<anims.length; i++)
			anims[i].restart();
	}
}
