package com.pirogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.pirogue.items.EmptyItem;
import com.pirogue.items.List;

public class Console {
	
	private int delta;
	private String arrowDir;
	public String enteredString;
	public String historic;
	public String line;
	List obj = new List();
	
	public Console() {
		this.enteredString = "";
		this.historic = " \n \n \n \n \n \n \n \n \n \n \n";
		this.line = ">";
	}
	
	public void update(int delta, String arrowDir) {
		this.delta = delta;
		this.arrowDir = arrowDir;
	}
	
	void render(Graphics g) throws SlickException
	{
		if (Constants.inConsole) {
			Color test = new Color(0f,0f,0f,0.35f);
			g.setColor(test);
			g.fillRect(0, 0, 500, 300);
			g.setColor(Color.white);
			g.drawString(enteredString,20,270);
			g.drawString(historic,10,10);
			g.drawString(line, 8, 270);
		}
		if (Constants.debug) {
			g.drawString("delta: " + delta, 100, 10);
			g.drawString("mousePressed: " + Constants.mousePressed, Constants.SCREEN_WIDTH-500, 10);
			g.drawString("mouseX: " + Constants.mouseX, Constants.SCREEN_WIDTH-300, 10);
			g.drawString("mouseY: " + Constants.mouseY, Constants.SCREEN_WIDTH-150, 10);
			g.drawString("arrowDir: " + arrowDir, Constants.SCREEN_WIDTH/2-100, 10);
		}
	
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
	
	
	void keyPressed(int key, char c) {
		if (key == Input.KEY_BACK)
		{
			if (enteredString.length()>0) {
			enteredString=enteredString.substring(0,(enteredString.length()-1));
		}}
		else if (key == Input.KEY_RETURN) {
			this.executeCommand(enteredString);
			this.historic=historic+"\n"+enteredString;
			this.enteredString="";
			
		}
		
		else enteredString+=c;
		int p;
		String[] commandes = historic.split("\n");
		p=commandes.length;
		System.out.println(p);
		if((p)>13){
		this.historic="";
		for(int i=2;i<p;i++)
		{
			historic+= "\n" + commandes[i] ;
			
		}
		}
	
		}
	
	
	void executeCommand(String command) {
		
		//int n=0;
		
		if (command.equals("walid")) System.out.println("OK. OP MODE ENABLED");
			
		String[] word = command.split(" ");
		switch(word[0]) {
		case "/give" :
			int n=6;
			double ID;
			while((!(Constants.dungeon.hero.inventory.objects[n] instanceof EmptyItem)))
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
				if((obj.Items[(int)ID])==null)
					break;
				else
				{
				System.out.println(ID);
				
				Constants.dungeon.hero.inventory.objects[n] = obj.Items[(int)ID];			
			}
		}
		
	}
	
/*	void componentActivated(AbstractComponent KEY_A) {
		
		
	};*/


}}}
