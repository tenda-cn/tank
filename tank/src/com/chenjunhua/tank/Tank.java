package com.chenjunhua.tank;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank extends GameObject {
	public int x,y;
	public int  preX, preY;
	private Group group = Group.BAD;
	private Dir dir = Dir.DOWN;
	
	private boolean living = true;
	private Random random = new Random();
	public Rectangle rect = new Rectangle();
	
	public static int WIDTH = ResourcesMgr.goodTankU.getWidth();
	public static int HEIGHT = ResourcesMgr.goodTankU.getHeight();
	
	private boolean moving = true;
	private  static final int SPEED = 5;
	public GameModel gm = null;
	
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

	public Tank(int x,int y,Dir dir,GameModel gm,Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.gm = gm;
		this.group = group;
		
		rect.x = x;
		rect.y = y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
	}
	public void paint(Graphics g) {
		if(!living)  gm.remove(this) ;
		switch (dir) {
		case LEFT:
			g.drawImage(this.group == Group.GOOD ? ResourcesMgr.goodTankL : ResourcesMgr.badTankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(this.group == Group.GOOD ? ResourcesMgr.goodTankR : ResourcesMgr.badTankR, x, y, null);
			break;
		case UP:
			g.drawImage(this.group == Group.GOOD ? ResourcesMgr.goodTankU : ResourcesMgr.badTankU, x, y, null);
			break;
		case DOWN:
			g.drawImage(this.group == Group.GOOD ? ResourcesMgr.goodTankD : ResourcesMgr.badTankD, x, y, null);
			break;

		default:
			break;
		}
		
		move();
		
	}
	private void move() {
		if(!moving) return;
		
		preX = x;
		preY = y;
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
			fire(CommonFire.getInstance());
		
		if(this.group == Group.BAD && random.nextInt(100)>95)
			randomDir();
		boundsCheck();
		
		//update rect
		rect.x = x;
		rect.y = y;
		
	}
	private void boundsCheck() {
		if(this.x < 0) x = 0;
		if(this.y < 30) y = 30;
		if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
		if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH;
		
		
	}
	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
		
	}
	public void fire(FireStrategy fireStrategy) {
		
		fireStrategy.fire(this);
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
	public void stop() {
		moving = false; 
	}
	public void turnDir() {
		x = preX;
		y = preY;
	}
	
}
