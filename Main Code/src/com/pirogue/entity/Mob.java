package com.pirogue.entity;

import com.pirogue.game.Constants;

public abstract class Mob extends Entity {

	protected int distX, distY;
	protected int aggro = 350;
	protected int range = Constants.blockSize+10;

	public Mob(int x, int y) {
		super(x, y);
	}

	public void pathfinding(int heroX, int heroY) {
		distX = this.x - heroX;//la distance qui separe le hero du mob en x
		distY = this.y - heroY;//pareil en y
		this.moving = -1;
		if(aggro()) {
			prio tabPrio[] = new prio[4];//prio est une énum pour l'ordre de priorité du mob sur la direction qu'il va choisir
			if(Math.abs(distY)<=Math.abs(distX) && distX>=0) {tabPrio[0]=prio.gauche; tabPrio[1]=prio.haut; tabPrio[2]=prio.bas; tabPrio[3]=prio.droite;}//détermine l'ordre de
			if(Math.abs(distY)<=Math.abs(distX) && distX<=0) {tabPrio[0]=prio.droite; tabPrio[1]=prio.bas; tabPrio[2]=prio.haut; tabPrio[3]=prio.gauche;}//priorité des directions
			if(Math.abs(distX)<=Math.abs(distY) && distY>=0) {tabPrio[0]=prio.haut; tabPrio[1]=prio.droite; tabPrio[2]=prio.gauche; tabPrio[3]=prio.bas;}//en fonction de la distance
			if(Math.abs(distX)<=Math.abs(distY) && distY<=0) {tabPrio[0]=prio.bas; tabPrio[1]=prio.gauche; tabPrio[2]=prio.droite; tabPrio[3]=prio.haut;}//qui le sépare du hero
			move(tabPrio);

		}
	}

	protected boolean aggro() {
		if(Math.sqrt(distX*distX+distY*distY)<aggro) {//detecte si le mob est assez proche pour pathfind
			if(Math.sqrt(distX*distX+distY*distY)<range) attack();//detecte si le mob est assez pres pour attaquer
			return true;
		}
		return false;
	}

	protected void move(prio tabPrio[]){
		if(!this.isColliding) {//si le mob peut passer, il choisi la premiere direction en fonction du chemin a parcourir
			if(tabPrio[0]==prio.haut) {this.moving = 0;}
			if(tabPrio[0]==prio.droite) {this.moving = 2;}
			if(tabPrio[0]==prio.bas) {this.moving = 4;}
			if(tabPrio[0]==prio.gauche) {this.moving = 6;}
		}
		else {//si le mob ne peut pas passer, il choisi la deuxieme direction en fonction du chemin a parcourir
			if(tabPrio[1]==prio.haut) {this.moving = 0;}
			if(tabPrio[1]==prio.droite) {this.moving = 2;}
			if(tabPrio[1]==prio.bas) {this.moving = 4;}
			if(tabPrio[1]==prio.gauche) {this.moving = 6;}
		}
		this.isColliding = false;
	}

	@Override
	public void hurt(int damages) {
		this.life -= damages; // TODO: prendre en compte l'armure
		this.hitCounter = 0;
	}

	protected abstract void attack();
}
