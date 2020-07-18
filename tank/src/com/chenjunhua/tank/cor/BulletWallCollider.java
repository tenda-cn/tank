package com.chenjunhua.tank.cor;

import com.chenjunhua.tank.Bullet;
import com.chenjunhua.tank.Explode;
import com.chenjunhua.tank.GameObject;
import com.chenjunhua.tank.Wall;
import com.chenjunhua.tank.Wall;

public class BulletWallCollider implements Collider {
	
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Bullet && o2 instanceof Wall) {
			Bullet bullet = (Bullet)o1;
			Wall wall = (Wall)o2;
			
			if(bullet.rect.intersects(wall.rect)) {
				bullet.die();		
			}
		}else if(o1 instanceof Wall && o2 instanceof Bullet) {
			return collide(o2, o1);
		}
			return true;
	}
}
