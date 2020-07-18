package com.chenjunhua.tank.cor;

import com.chenjunhua.tank.GameObject;

public interface Collider {
	boolean collide(GameObject o1, GameObject o2);
}
