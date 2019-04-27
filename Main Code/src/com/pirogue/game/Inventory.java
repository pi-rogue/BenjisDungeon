package com.pirogue.game;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.pirogue.items.EmptyItem;
import com.pirogue.items.Item;


public class Inventory {

	private boolean isVisible;
	private int backgroundX, backgroundY;
	public int inventorySize=0;
	
	private Image background, cellsImg, selected;
	private ArrayList<Rectangle> cells;
	private Rectangle[] cellsEquipment;
	private Rectangle heroCell;

	public Item[] objects;
	public Item[] equipment;
	
	public Inventory() throws SlickException {
		this.cellsImg = new Image(Constants.inventoryCells);
		this.background = new Image(Constants.inventoryBackground);
		this.selected = new Image(Constants.inventorySelected);

		this.cells = new ArrayList<Rectangle>();
		this.cellsEquipment = new Rectangle[6];
		this.equipment = new Item[6];
		this.isVisible = false;
		this.backgroundX = (Constants.SCREEN_WIDTH-background.getWidth())/2;
		this.backgroundY = (Constants.SCREEN_HEIGHT-background.getHeight())/2;		
		
		loadCells();
		this.objects = new Item[inventorySize];
		for (int n=0; n<inventorySize; n++) {
			objects[n] = new EmptyItem();
		}
		for (int n=0; n<6; n++) {
			equipment[n] = new EmptyItem();
		}
}
	
	public void render(Graphics g) {
		g.drawImage(this.background, backgroundX, backgroundY);

		int n=0;
		for (Rectangle rect : cells) {
			g.drawImage(objects[n].getTexture(), rect.getMinX(), rect.getMinY());
			if (rect.contains(Constants.mouseX, Constants.mouseY)) {
				g.drawImage(selected, rect.getMinX(), rect.getMinY());
			}
			n++;
		}

		n=0;
		for (Rectangle rect : cellsEquipment) {
			g.drawImage(equipment[n].getTexture(), rect.getMinX(), rect.getMinY());
			if (rect.contains(Constants.mouseX, Constants.mouseY)) {
				g.drawImage(selected, rect.getMinX(), rect.getMinY());
			}
			n++;
		}
	}
	
	private void loadCells() {
		for (int j=0; j<cellsImg.getHeight(); j++) { 
		for (int i=0; i<cellsImg.getWidth(); i++) {
			Color pixel = cellsImg.getColor(i, j); // On récupère la couleur de chaque pixel
			if (!pixel.equals(Color.white)) {
				int cellWidth=0, cellHeight=0;
				for (int x=i; x<cellsImg.getWidth(); x++) {
					if (cellsImg.getColor(x, j).equals(pixel)) cellWidth++;
					else break;
				}
				for (int y=j; y<cellsImg.getHeight(); y++) {
					if (cellsImg.getColor(i, y).equals(pixel)) cellHeight++;
					else break;
				}
				if (cellWidth==Constants.cellSize && cellHeight==Constants.cellSize) {
					Rectangle rect = new Rectangle(i+backgroundX , j+backgroundY, cellWidth, cellHeight);
					if (pixel.equals(Constants.invCell)) {
						cells.add(rect);
						this.inventorySize++;
					}
					else if (pixel.equals(Constants.head)) cellsEquipment[0] = rect;
					else if (pixel.equals(Constants.chest)) cellsEquipment[1] = rect;
					else if (pixel.equals(Constants.legs)) cellsEquipment[2] = rect;
					else if (pixel.equals(Constants.foots)) cellsEquipment[3] = rect;
					else if (pixel.equals(Constants.leftHand)) cellsEquipment[4] = rect;
					else if (pixel.equals(Constants.rightHand)) cellsEquipment[5] = rect;
				}
				else if (cellWidth==cellHeight && pixel.equals(Constants.heroCell) && this.heroCell == null) {
					Rectangle rect = new Rectangle(i+backgroundX , j+backgroundY, cellWidth, cellHeight);
					this.heroCell = rect;
				}
			}
		}}
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public int getSize() {
		return this.inventorySize;
	}
	
	public Rectangle getHeroCell() {
		return heroCell;
	}
}
