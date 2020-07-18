package com.chenjunhua.tank;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {
	private static final int SPEED = 10;
	public static int WIDTH = ResourcesMgr.bulletD.getWidth();
	public static int HEIGHT = ResourcesMgr.bulletD.getHeight();
	
	private int x,y;
	private Dir dir;
	public Group group = Group.BAD;
	public Rectangle rect = new Rectangle();
	
	private boolean living = true;
	public GameModel gm = null;
	
	public Bullet(int x, int y, Dir dir, GameModel gm,Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.gm = gm;
		this.group = group;
		
		rect.x = x;
		rect.y = y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		
		gm.add(this);
	}
	
	public void paint(Graphics g) {
		if(!living)
			gm.remove(this);
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
		
		//update rect
		rect.x = x;
		rect.y = y;
		
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT  )
			living = false;
	}

	public void collideWith(Tank tank) {
		if(this.group == tank.getGroup()) return;
		
		if(rect.intersects(tank.rect)) {
			tank.die();
			this.die();
			
			int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
			int eY = tank.getY() + Tank.HEIGHT/2 -Explode.HEIGHT/2;
			gm.add(new Explode(eX, eY, gm));
		}
		
	}
	public void die() {
		this.living = false;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	
}