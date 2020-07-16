package com.chenjunhua.tank;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tank {
	private int x,y;
	private Group group = Group.BAD;
	private Dir dir = Dir.DOWN;
	private boolean living = true;
	private Random random = new Random();
	public static int WIDTH = ResourcesMgr.tankD.getWidth();
	public static int HEIGHT = ResourcesMgr.tankD.getHeight();
	private boolean moving = true;
	private  static final int SPEED = 2;
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

	public Tank(int x,int y,Dir dir,TankFrame tf,Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
	}
	public void paint(Graphics g) {
		if(!living) this.tf.tanks.remove(this) ;
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
		if(this.group == Group.GOOD)
			new Thread(()->new Audio("audio/tank_move.wav").play()).start();
		
		if(this.group == Group.BAD && random.nextInt(100)>95) 
			this.fire();
		
		if(this.group == Group.BAD && random.nextInt(100)>95)
			randomDir();
	}
	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
		
	}
	public void fire() {
		if(this.group == Group.GOOD)
			new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
		
		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		tf.bullets.add(new Bullet(bX, bY, dir,tf,this.group));
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void die() {
		living = false;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
}
