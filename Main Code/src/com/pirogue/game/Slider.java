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
	public int centercX;
	public int centerX;
	public int centerY;
	public int centercY;
	
	
	public Slider(int centerX, int centerY,int centercX,int centercY) throws SlickException {
		this.centercY=centercY;
		this.centerY=centerY;		
		this.centerX=centerX;
		this.centercX=centercX;
		this.selected = new Image("assets/gui/selected_cursor.png");
		this.background = new Image("assets/gui/buttons/background_with_bar.png");
		this.cursor = new Image("assets/gui/buttons/cursor.png");
		this.rect = new Rectangle(centerX-this.background.getWidth()/2, centerY-this.background.getHeight()/2, this.background.getWidth(), this.background.getHeight());
		this.rect_cursor = new Rectangle(centerX-this.cursor.getWidth()/2+40, centerY-this.cursor.getHeight()/2, this.cursor.getWidth(), this.cursor.getHeight());
	}
	
	public void render(Graphics g) {
		g.drawImage(background, rect.getMinX(), rect.getMinY());
		g.drawImage(cursor, rect_cursor.getMinX(), rect_cursor.getMinY());
		if (rect_cursor.contains(Constants.mouseX, Constants.mouseY) && (rect_cursor_selected = true ))
			g.drawImage(selected, rect_cursor.getMinX(), rect_cursor.getMinY());
		
	}
	
	
	


	public void update() {
		
		
		
		
		if (Constants.mousePressed && !Constants.mouseWasPressed && rect_cursor.contains(Constants.mouseX, Constants.mouseY)) {
			rect_cursor_selected = true;
		}
		else if(!Constants.mousePressed) {
			rect_cursor_selected = false;
		}
			
		if (rect_cursor_selected)
		{
			this.centercX=Constants.mouseX;
			this.rect_cursor = new Rectangle(centercX-this.cursor.getWidth()/2, centercY-this.cursor.getHeight()/2, this.cursor.getWidth(), this.cursor.getHeight());
		
			
	}	}	
}
