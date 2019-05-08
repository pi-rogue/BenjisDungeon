package com.pirogue.game.util;

import java.io.File;
import java.util.HashMap;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.pirogue.game.Constants;

public class AnimationsContainer extends HashMap<String, Animation[]> {

	private static final long serialVersionUID = -5410647083482878529L;

	public AnimationsContainer() throws SlickException {
			this.initAnimations(new File("src/assets/sprites"));
	}
	
	public Animation[] get(String key) {
		if (key.matches(".*empty.*")) {
			return super.get("empty");
		}
		Animation[] anims = super.get(key);
		if (anims == null) return super.get("missing"); 
		return anims;
	}
	
	public void initAnimations(File currentFile) throws SlickException {
		for (File file : currentFile.listFiles()) {
			if (file.isDirectory())
				initAnimations(file);
			else {
				String key = String.join(" ", file.getPath().substring(19, file.getPath().indexOf(".")).split("\\\\"));
				key = key.split(" ", 2)[1];
				
				int cellWidth = Constants.blockSize * (key.matches("attack .*") ? 2:1); // Permet de gérer les spritesheets bizarres de wiwi
				int cellHeight = Constants.blockSize; // Si on a plus tard des spritesheets avec une hauteur plus grande (pour l'attaque vers le haut par exemple ?)
				int duration = key.matches(".*slime.*") ? 150 : 100;
				SpriteSheet sprite = new SpriteSheet(file.getPath(), cellWidth, cellHeight);
				int spriteImgWidth = sprite.getWidth();
				int spriteImgHeight = sprite.getHeight();
				Animation[] anims = new Animation[spriteImgHeight/cellHeight];

				for (int n=0; n<spriteImgHeight/cellHeight; n++) {
					Animation anim = new Animation();
					for (int i=0; i<spriteImgWidth/cellWidth; i++) {
						anim.addFrame(sprite.getSprite(i, n), duration);
					}
					anims[n] = anim;
				}
				this.put(key, anims);
			}
		}
	}
}
