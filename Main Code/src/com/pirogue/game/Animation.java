package com.pirogue.game;

public class Animation extends org.newdawn.slick.Animation {

	public Animation getScaledCopy(float width, float height) {
		Animation newAnim = new Animation();
		for (int i=0; i<this.getFrameCount(); i++) {
			newAnim.addFrame(this.getImage(i).getScaledCopy((int)width, (int)height), this.getDuration(i));
		}
		return newAnim;
	}
	
}
