package com.pirogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Inventory {

	public Rectangle background;
	public Image title;
	private boolean isVisible;
	private int nCellsHorizontal, nCellsVertical, cellSize;
	
	public Inventory() throws SlickException {
		this.title = new Image("assets/gui/inventory2.png");
		this.background = new Rectangle(Constants.SCREEN_WIDTH*0.2f, Constants.SCREEN_HEIGHT*0.2f, Constants.SCREEN_WIDTH*0.6f, Constants.SCREEN_HEIGHT*0.6f);
		this.isVisible = false;
		this.nCellsHorizontal = 8;
		this.nCellsVertical = 4;
		this.cellSize = 64;
	}
	
	public void render(Graphics g) {
		int spaceW = (int)((background.getWidth()-nCellsHorizontal*cellSize)/(nCellsHorizontal+1));
		int spaceH = (int)((background.getHeight()-title.getHeight()*2-nCellsVertical*cellSize)/(nCellsVertical+1));

		g.setColor(Color.lightGray);
		g.fill(this.background);
		g.drawImage(title, background.getMinX()+title.getWidth()/2, background.getMinY()+title.getHeight());
		for (int i=0; i<nCellsHorizontal; i++) {
			for (int j=0; j<nCellsVertical; j++) {
				Rectangle cell = new Rectangle(background.getMinX()+spaceW*(i+1)+cellSize*i, background.getMinY()+title.getHeight()*2+spaceH*(j+1)+cellSize*j, cellSize, cellSize);
				if (cell.contains(Constants.mouseX, Constants.mouseY) && Constants.mousePressed) g.setColor(Color.yellow);
				else if (cell.contains(Constants.mouseX, Constants.mouseY)) g.setColor(Color.gray);
				else g.setColor(Color.darkGray);
				g.fill(cell);
			}
		}
	}
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
}
