package com.chenjunhua.tank.abstractfactory;

import java.awt.Color;
import java.awt.Graphics;

import com.chenjunhua.tank.Dir;
import com.chenjunhua.tank.ResourcesMgr;
import com.chenjunhua.tank.TankFrame;

public class RectExplode extends BaseExplode {

	public static int WIDTH = ResourcesMgr.explodes[1].getWidth();
	public static int HEIGHT = ResourcesMgr.explodes[1].getHeight();
	
	private int x,y;
	private Dir dir;

	private int step = 0;
	private boolean living = true;
	private TankFrame tf = null;
	
	public RectExplode(int x, int y, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
		//new Thread(()->new Audio("audio/explode.wav").loop()).start();
	
	}
	
	public void paint(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(x, y, 10*step, 10*step);
		step++;
		if(step >= 5)
			tf.explodes.remove(this);
		g.setColor(color);
	}

}
