package com.chenjunhua.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Explode extends GameObject {

	public static int WIDTH = ResourcesMgr.explodes[1].getWidth();
	public static int HEIGHT = ResourcesMgr.explodes[1].getHeight();
	
	private int x,y;
	private Dir dir;

	private int step = 0;
	private boolean living = true;
	
	public Explode(int x, int y) {
		this.x = x;
		this.y = y;
		//new Thread(()->new Audio("audio/explode.wav").loop()).start();
	
		GameModel.getInstance().add(this);
	}
	
	public void paint(Graphics g) {
		g.drawImage(ResourcesMgr.explodes[step++], x, y, null);
		if(step>=ResourcesMgr.explodes.length)
			GameModel.getInstance().remove(this);
	}


}