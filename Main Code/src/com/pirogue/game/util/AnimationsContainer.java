package com.pirogue.game.util;

import java.io.File;
import java.util.HashMap;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.pirogue.game.Constants;

public class AnimationsContainer extends HashMap<String, Animation[]> {
/*
 * Cette classe est un conteneur qui fonctionne sur le principe de key/value (un peu comme les dictionnaires).
 * Les sprites sont chargées comme des tableaux d'objets Animation selon le schéma suivant:
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
 * que 'assets/sprites/heroes/equipment/basic_daggers.png' et surtout l'afficher de la même manière. La clé
 * permettant d'identifier un tableau d'animations est le chemin vers l'image de sa spritesheet, en partant
 * du dossier "src/assets/sprites", en remplaçant les '/' par des espaces et en enlevant l'extension.
 * 
 * Exemple: pour obtenir les animations de l'image 'src/assets/sprites/heroes/rogue.png'
 * Animation[] anims = Constants.animations.get("heroes rogue");
 */

	public AnimationsContainer() throws SlickException {
			this.initAnimations(new File("src/assets/sprites"));
	}
		
	public void initAnimations(File currentDirectory) throws SlickException {
	/* Fonction récurrente qui permet de parcourir toute une arborescence de fichiers. */
		for (File file : currentDirectory.listFiles()) { // Pour chaque fichier du dossier que l'on regarde
			if (file.isDirectory()) // Si c'est un dossier, alors on regarde dans ce dossier (récurrence)
				initAnimations(file);
			else { // Sinon, on charge l'image selon le schéma précisé plus haut
				if (!(file.getPath().split("\\.")[file.getPath().split("\\.").length-1].equalsIgnoreCase("png"))) { // On teste l'extention au cas où quelqu'un laisserait traîner un fichier .aesprite
					System.out.println("## INFO ## Ignoring spritesheet '" + file.getPath() + "', only PNG images are allowed.");
					continue; // On skip ce tour de boucle
				}
				
				String key = String.join(" ", file.getPath().substring(19, file.getPath().indexOf(".")).split("\\\\"));
				int cellWidth = Constants.blockSize * (key.matches("heroes attack .*") ? 2:1); // Permet de gérer des spritesheets qui ne sont pas 64x64
				int cellHeight = Constants.blockSize; // Si on a plus tard des spritesheets avec une hauteur plus grande (pour l'attaque vers le haut par exemple ?)
				int duration = key.matches(".*slime.*") ? 150 : key.matches("heroes attack .*") ? 65 : 100; // Selon l'animation on veut des durées différentes
				SpriteSheet sprite = new SpriteSheet(file.getPath(), cellWidth, cellHeight);
				Animation[] anims = new Animation[sprite.getHeight()/cellHeight]; // Tableau contenant une animation par ligne de spritesheet

				for (int j=0; j<sprite.getHeight()/cellHeight; j++) {
					Animation anim = new Animation();
					for (int i=0; i<sprite.getWidth()/cellWidth; i++) {
						anim.addFrame(sprite.getSprite(i, j), duration);
					}
					anims[j] = anim;
				}
				this.put(key, anims);
			}
		}
	}

	public Animation[] get(String key) {
	/* On remplace la méthode get de HashMap pour éviter un crash si on demande une image inexistante */  
		if (key.matches(".*empty.*")) // TODO: Optimisation possible: retourner un null et vérifier si c'est null avant d'afficher pour éviter d'afficher des images vides
			return super.get("debug empty");
		
		Animation[] anims = super.get(key);
		if (anims == null)
			return super.get("debug missing"); 
		return anims;
	}
}
