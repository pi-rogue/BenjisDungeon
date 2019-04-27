package com.pirogue.entity;

public abstract class Mob extends Entity {
	
	protected int distX, distY;	
	int cpt=0;
	
	public Mob(int x, int y) {
		super(x, y);
	}
	
	public void pathfinding(int heroX, int heroY) {
		distX = this.x - heroX;
		distY = this.y - heroY;
		//cpt++;
		//if(cpt>200) {System.out.println(distX+"   "+distY); cpt=0;}
		this.moving = -1;
		if(aggro()) {
			prio tabPrio[] = new prio[4];
			if(Math.abs(distY)<=Math.abs(distX) && distX>=0) {tabPrio[0]=prio.gauche; tabPrio[1]=prio.haut; tabPrio[2]=prio.bas; tabPrio[3]=prio.droite;}	
			if(Math.abs(distY)<=Math.abs(distX) && distX<=0) {tabPrio[0]=prio.droite; tabPrio[1]=prio.bas; tabPrio[2]=prio.haut; tabPrio[3]=prio.gauche;}
			if(Math.abs(distX)<=Math.abs(distY) && distY>=0) {tabPrio[0]=prio.haut; tabPrio[1]=prio.droite; tabPrio[2]=prio.gauche; tabPrio[3]=prio.bas;}
			if(Math.abs(distX)<=Math.abs(distY) && distY<=0) {tabPrio[0]=prio.bas; tabPrio[1]=prio.gauche; tabPrio[2]=prio.droite; tabPrio[3]=prio.haut;}		
			move(tabPrio);	
		}
	}
	
	protected boolean aggro() {
		if(Math.sqrt(distX*distX+distY*distY)<350) return true;
		return false;
	}
	
	protected void move(prio tabPrio[]){
		this.moving = -1;
		if(!this.isColliding) {
			if(tabPrio[0]==prio.haut) {this.moving = 0;}
			if(tabPrio[0]==prio.droite) {this.moving = 2;}
			if(tabPrio[0]==prio.bas) {this.moving = 4;}
			if(tabPrio[0]==prio.gauche) {this.moving = 6;}
		}
		else {
			if(tabPrio[1]==prio.haut) {this.moving = 0;}
			if(tabPrio[1]==prio.droite) {this.moving = 2;}
			if(tabPrio[1]==prio.bas) {this.moving = 4;}
			if(tabPrio[1]==prio.gauche) {this.moving = 6;}
		}
	}
	
	public abstract void attack();
}
