package com.pirogue.game;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tests.xml.Item;


public class Inventory {

	private Image background, cellsImg, selected;
	private ArrayList<Rectangle> cells;
	private Rectangle[] cellsEquipment;
	private boolean isVisible;
	private int backgroundX, backgroundY;
	public Item[] objects;
	public Item head, chest, legs, foots, leftHand, rightHand;
	public int inventorySize=0;
	
	public Inventory() throws SlickException {
		this.cellsImg = new Image(Constants.inventoryCells);
		this.background = new Image(Constants.inventoryBackground);
		this.selected = new Image(Constants.inventorySelected);

		this.cells = new ArrayList<Rectangle>();
		this.cellsEquipment = new Rectangle[6];
		this.isVisible = false;
		this.backgroundX = (Constants.SCREEN_WIDTH-background.getWidth())/2;
		this.backgroundY = (Constants.SCREEN_HEIGHT-background.getHeight())/2;		
		
		this.loadCells();
	}
	
	public void render(Graphics g) {
		g.drawImage(this.background, backgroundX, backgroundY);

		for (Rectangle rect : cells) {
			if (rect.contains(Constants.mouseX, Constants.mouseY)) {
				g.drawImage(selected, rect.getMinX(), rect.getMinY());
			}
		}

		for (Rectangle rect : cellsEquipment) {
			if (rect.contains(Constants.mouseX, Constants.mouseY)) {
				g.drawImage(selected, rect.getMinX(), rect.getMinY());
			}
		}
}
	
	public void loadCells() {
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
}
