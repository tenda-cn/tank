package com.chenjunhua.tank;
import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x,y;
	Dir dir = Dir.DOWN;
	private boolean moving = false;
	private  static final int SPEED = 5;
	private TankFrame tf = null;
	
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public Dir getDir() {
		return dir;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public Tank(int x,int y,Dir dir,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	public void paint(Graphics g) {
		switch (dir) {
		case LEFT:
			g.drawImage(ResourcesMgr.tankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourcesMgr.tankR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourcesMgr.tankU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourcesMgr.tankD, x, y, null);
			break;

		default:
			break;
		}
		
		move();
		
	}
	private void move() {
		if(!moving) return;
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
	public void fire() {
		tf.bullets.add(new Bullet(x + 22, y + 22, dir,tf));
	}
}
