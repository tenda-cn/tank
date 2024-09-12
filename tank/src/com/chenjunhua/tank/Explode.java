package com.chenjunhua.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.chenjunhua.tank.abstractfactory.BaseBullet;
import com.chenjunhua.tank.abstractfactory.BaseExplode;

public class Explode extends BaseExplode {

	public static int WIDTH = ResourcesMgr.explodes[1].getWidth();
	public static int HEIGHT = ResourcesMgr.explodes[1].getHeight();
	
	private int x,y;
	private Dir dir;

	private int step = 0;
	private boolean living = true;
	private TankFrame tf = null;
	
	public Explode(int x, int y, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
		//new Thread(()->new Audio("audio/explode.wav").loop()).start();
	
	}
	
	public void paint(Graphics g) {
		g.drawImage(ResourcesMgr.explodes[step++], x, y, null);
		if(step>=ResourcesMgr.explodes.length)
			tf.explodes.remove(this);
	}

}