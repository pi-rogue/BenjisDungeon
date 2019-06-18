package com.pirogue.game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
//import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Slider {
	
	private Image background;
	private Image cursor;
	private Image selected;
	private Rectangle rect;
	private Rectangle rect_cursor;
	private boolean rect_cursor_selected = false;
	private float variable;
	public int centercX;//centre du curseur en x
	public int centerX;
	public int centerY;
	public int centercY;//centre du curseur en y
	private String label;
	
	
	public Slider(int centerX, int centerY,int centercX,int centercY,String label) throws SlickException {
		this.centercY=centercY;
		this.centerY=centerY;		
		this.centerX=centerX;
		this.centercX=centercX;
		this.label=label;
		this.selected = new Image("assets/gui/selected_cursor.png");
		this.background = new Image("assets/gui/buttons/background_with_bar_" + label +".png");
		this.cursor = new Image("assets/gui/buttons/cursor.png");
		this.rect = new Rectangle(centerX-this.background.getWidth()/2, centerY-this.background.getHeight()/2, this.background.getWidth(), this.background.getHeight());
		this.rect_cursor = new Rectangle(centerX-this.cursor.getWidth()/2+20, centerY-this.cursor.getHeight()/2, this.cursor.getWidth(), this.cursor.getHeight());
	}
	
	public void render(Graphics g) {
		g.drawImage(background, rect.getMinX(), rect.getMinY());
		g.drawImage(cursor, rect_cursor.getMinX(), rect_cursor.getMinY());
		if (((rect_cursor.contains(Constants.mouseX, Constants.mouseY) && !Constants.mousePressed) || (rect_cursor_selected == true )))
			g.drawImage(selected, rect_cursor.getMinX(), rect_cursor.getMinY());
		
	}
	
	
	


	public void update() {
		//Variable est une échelle de 0 à 100
		if (Constants.mousePressed && !Constants.mouseWasPressed && rect_cursor.contains(Constants.mouseX, Constants.mouseY)) {
			rect_cursor_selected = true;
		}
		else if(!Constants.mousePressed) {
			rect_cursor_selected = false;
		}
			
		if (rect_cursor_selected) {
			if(Constants.mouseX<460) 
				this.centercX = 460;
			else if (Constants.mouseX>910)	
				this.centercX = 910;				
			else {
			this.centercX=Constants.mouseX;
			}
			this.rect_cursor = new Rectangle(centercX-this.cursor.getWidth()/2, centercY-this.cursor.getHeight()/2, this.cursor.getWidth(), this.cursor.getHeight());
		}
		variable = (float) ((this.centercX - 460.0)/(910.0-460.0)*100);
	}
}
