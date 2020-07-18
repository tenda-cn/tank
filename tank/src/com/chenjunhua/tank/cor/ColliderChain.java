package com.chenjunhua.tank.cor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.chenjunhua.tank.GameObject;

public class ColliderChain implements Collider{
	private List<Collider> colliders = new LinkedList<Collider>();
	
	public ColliderChain() {
		add(new BulletTankCollider());
		add(new TwoTankCollider());
	}
	
	public void add(Collider c) {
		colliders.add(c);
	}

	public boolean collide(GameObject o1, GameObject o2) {
		for(Collider collider:colliders) {
			if(!collider.collide(o1, o2))
				return false;
		}
		return true;
	}
}
