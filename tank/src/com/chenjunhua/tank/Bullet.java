package com.chenjunhua.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	private static final int SPEED = 10;
	public static int WIDTH = ResourcesMgr.bulletD.getWidth();
	public static int HEIGHT = ResourcesMgr.bulletD.getHeight();
	private int x,y;
	private Dir dir;
	private boolean living = true;
	private TankFrame tf = null;
	
	public Bullet(int x, int y, Dir dir, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
		if(!living)
			tf.bullets.remove(this);
		switch (dir) {
		case LEFT:
			g.drawImage(ResourcesMgr.bulletL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourcesMgr.bulletR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourcesMgr.bulletU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourcesMgr.bulletD, x, y, null);
			break;

		default:
			break;
		}
		
		move();
	}

	private void move() {
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
		}
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT  )
			living = false;
	}

	public void collideWith(Tank tank) {
		Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		if(rect1.intersects(rect2)) {
			tank.die();
			this.die();
		}
		
	}
	private void die() {
		this.living = false;
	}
}