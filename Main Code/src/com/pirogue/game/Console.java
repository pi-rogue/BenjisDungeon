package com.pirogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.pirogue.items.List;
import com.pirogue.game.Inventory;
import com.pirogue.items.Axe;
import com.pirogue.items.Daggers;
import com.pirogue.items.EmptyItem;
import com.pirogue.items.Item;

public class Console {
	
	
	public String enteredString;
	List obj = new List();
	
	public Console() {
		this.enteredString = "";
	}
	
	void render(Graphics g) throws SlickException
	{
		Color test = new Color(0f,0f,0f,0.35f);
		g.setColor(test);
		g.fillRect(0, 0, 500, 300);
		g.setColor(Color.white);
		g.drawString(enteredString,0,30);
	
	
/*		Font font = new UnicodeFont(new java.awt.Font("DejaVu Serif", java.awt.Font.PLAIN, 20));
		TextField zoneDeSaisie = null;
		zoneDeSaisie = new TextField(Constants.container, font, 0, 0, 500, 300);
		zoneDeSaisie.setBorderColor(Color.black);
		zoneDeSaisie.getText();
		zoneDeSaisie.setTextColor(Color.white);
		zoneDeSaisie.render(Constants.container,g);
		zoneDeSaisie.deactivate();*/
		//Input input = Constants.container.getInput();
	}
	
	void keyPressed(int key, char c) throws SlickException {
		if (key == Input.KEY_BACK)
		{
			if (enteredString.length()>0) {
			enteredString=enteredString.substring(0,(enteredString.length()-1));
		}}
		else if (key == Input.KEY_RETURN) {
			this.executeCommand(enteredString);
			this.enteredString="";
		}
		else enteredString+=c;
	}
	
	void executeCommand(String command) throws SlickException {
		
		//int n=0;
		
		if (command.equals("walid")) System.out.println("OK. OP MODE ENABLED");
			
		String[] word = command.split(" ");
		switch(word[0]) {
		case "/give" :
			int n=0;
			double ID;
			while((!(Inventory.objects[n] instanceof EmptyItem)))
			{
				n++;
			}
			if (word[1].equals("empty") || word[1].equals(""))
			{
				break;
			}
			else
			{
				word[1]=word[1].replaceAll("[^0-9\\.]", "");
				ID = Double.parseDouble(word[1]);
				
			if(ID>=200000)
			{
				break;
			}
			else
			{
				System.out.println(ID);
				
				Inventory.objects[n] = obj.Items[(int)ID];			
			}
		}
		
	}
	
/*	void componentActivated(AbstractComponent KEY_A) {
		
		
	};*/


}}
