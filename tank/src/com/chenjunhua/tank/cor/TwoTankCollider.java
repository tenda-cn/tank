package com.chenjunhua.tank.cor;

import com.chenjunhua.tank.Bullet;
import com.chenjunhua.tank.Explode;
import com.chenjunhua.tank.GameObject;
import com.chenjunhua.tank.Tank;

public class TwoTankCollider implements Collider {
	
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Tank && o2 instanceof Tank) {
			Tank tank1 = (Tank)o1;
			Tank tank2 = (Tank)o2;
			
			
			if(tank1.rect.intersects(tank2.rect)) {
				tank1.turnDir();
				tank2.turnDir();
			}
		}
		return true;
			
	}
}
