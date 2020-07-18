package com.chenjunhua.tank.cor;

import com.chenjunhua.tank.Tank;
import com.chenjunhua.tank.Explode;
import com.chenjunhua.tank.GameObject;
import com.chenjunhua.tank.Wall;
import com.chenjunhua.tank.Wall;

public class TankWallCollider implements Collider {
	
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Tank && o2 instanceof Wall) {
			Tank tank = (Tank)o1;
			Wall wall = (Wall)o2;
			
			if(tank.rect.intersects(wall.rect)) {
				tank.turnDir();		
			}
		}else if(o1 instanceof Wall && o2 instanceof Tank) {
			return collide(o2, o1);
		}
			return true;
	}
}
