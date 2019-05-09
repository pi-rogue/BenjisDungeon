package com.pirogue.game;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.pirogue.game.util.Animation;
import com.pirogue.items.EmptyItem;
import com.pirogue.items.Item;


public class Inventory {

	private boolean isVisible = false;
	private int backgroundX, backgroundY;
	public int inventorySize=0;
	
	private Image background, cellsImg, selected;
	private ArrayList<Rectangle> cells;
	private Rectangle heroCell;

	public Item[] objects;
	public Item selectedItem;
	private int selectedItemIndex = -1;
	private boolean wasClicked = false;
	
	public Inventory() throws SlickException {
		this.cellsImg = new Image(Constants.inventoryCells);
		this.background = new Image(Constants.inventoryBackground);
		this.selected = new Image(Constants.inventorySelected);
		this.selectedItem = new EmptyItem();

		this.cells = new ArrayList<Rectangle>();
		this.backgroundX = (Constants.SCREEN_WIDTH-background.getWidth())/2;
		this.backgroundY = (Constants.SCREEN_HEIGHT-background.getHeight())/2;		
		
		loadCells();
		objects = new Item[inventorySize + 6];
		for (int n=0; n<inventorySize+6; n++) {
			objects[n] = new EmptyItem();
		}
}
	
	public boolean update() {
		// La valeur retournée est 'true' si il faut rafraichir les animations, 'false' sinon (permet de ne pas refresh si il n'y a pas besoin)
		Input input = Constants.container.getInput();
		
		if (input.isKeyDown(Input.KEY_LSHIFT) && Constants.mousePressed && !wasClicked) { // ----- Shift + click
			wasClicked = Constants.mousePressed;
			System.out.println("Shift click !"); // TODO
		}
		else if (Constants.mousePressed && !wasClicked && selectedItemIndex==-1) { // ------------ Drag
			wasClicked = Constants.mousePressed;
			int n=0;
			for (Rectangle rect : cells) {
				if (rect.contains(Constants.mouseX, Constants.mouseY)) {
					selectedItem = objects[n];
					objects[n] = new EmptyItem();
					selectedItemIndex = n;
					return (n<6 ? true : false);
				}
				n++;
			}
		}
		else if (!Constants.mousePressed && wasClicked) { // ------------------------------------- Drop
			wasClicked = Constants.mousePressed;
			int n=0;
			for (Rectangle rect : cells) {
				if (rect.contains(Constants.mouseX, Constants.mouseY)) {
					Item tmp = objects[n];
					objects[n] = selectedItem;
					objects[selectedItemIndex] = tmp;
					selectedItem = new EmptyItem();
					selectedItemIndex = -1;
					return (n<6 ? true : false);
				}
				n++;
			}
			
			if (!(selectedItem instanceof EmptyItem) && selectedItemIndex!=-1) { // Si il y a eu un problème et le selectedItem est pas vide, on remet l'item à sa place
				objects[selectedItemIndex] = selectedItem;
				selectedItem = new EmptyItem();
				selectedItemIndex=-1;
			}
			else { // Cas impossible mais on le met au cas où pour ne pas perdre d'item
				System.out.println("Il y a un probleme dans Inventory.update !");
				for (n=6; n<inventorySize; n++) {
					if (objects[n] instanceof EmptyItem) {
						objects[n] = selectedItem;
						selectedItem = new EmptyItem();
						selectedItemIndex = -1;
						break;
					}
				}
			}
			return false;
		}
		
		return false;
	}
	
	public void render(Graphics g, Animation[][] inventoryAnims, int facing) {
		g.drawImage(this.background, backgroundX, backgroundY);
		
		// Affichage de la case sur laquelle se trouve la souris //
		int n=0;
		for (Rectangle rect : cells) {
			g.drawImage(objects[n].getTexture(), rect.getMinX(), rect.getMinY());
			if (rect.contains(Constants.mouseX, Constants.mouseY)) {
				g.drawImage(selected, rect.getMinX(), rect.getMinY());
			}
			n++;
		}
		
		// Affichage du héros //
		for (Animation[] animation : inventoryAnims) {
			g.drawAnimation(animation[facing], heroCell.getMinX(), heroCell.getMinY());
		}
		
		// Affichage de l'item selectionné
		if (!(selectedItem instanceof EmptyItem)) {
			Image texture = selectedItem.getTexture();
			g.drawImage(texture, Constants.mouseX-texture.getWidth()/2, Constants.mouseY-texture.getHeight()/2);
		}
	}
	
	private void loadCells() {
		for (int i=0; i<6; i++) cells.add(new Rectangle(0, 0, 0, 0)); // On met 6 cases vides au début de la liste pour les 6 équipements
		
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
					else if (pixel.equals(Constants.head)) cells.set(0, rect);
					else if (pixel.equals(Constants.chest)) cells.set(1, rect);
					else if (pixel.equals(Constants.legs)) cells.set(2, rect);
					else if (pixel.equals(Constants.foots)) cells.set(3, rect);
					else if (pixel.equals(Constants.leftHand)) cells.set(4, rect);
					else if (pixel.equals(Constants.rightHand)) cells.set(5, rect);
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
