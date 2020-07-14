package com.chenjunhua.tank;

import java.awt.Graphics;

public class Tank {
	private int x,y;
	Dir dir = Dir.DOWN;
	public Dir getDir() {
		return dir;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	private  static final int SPEED = 10;
	public Tank(int x,int y,Dir dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public void paint(Graphics g) {
		g.fill3DRect(x, y, 50, 50, true);
		switch (dir) {
		case LEFT:
			x -= SPEED; 
			break;
		case RIGHT:
			x += SPEED; 
			break;
		case UP:
			y -= SPEED; 
			break;
		case DOWN:
			y += SPEED; 
			break;
			
		default:
			break;
		}
	}
}
