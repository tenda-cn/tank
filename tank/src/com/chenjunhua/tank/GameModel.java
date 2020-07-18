package com.chenjunhua.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import com.chenjunhua.tank.cor.ColliderChain;


public class GameModel {
	
	ColliderChain chain =new ColliderChain();
	
	Tank myTank = new Tank(200, 400, Dir.DOWN, this,Group.GOOD);
	
	List<GameObject> objects = new ArrayList<>(); 
		
		
	public void add(GameObject object) {
		objects.add(object);
	}
	
	public void remove(GameObject object) {
		objects.remove(object); 
	}
	
	public GameModel() {

		int initTankCount =Integer.parseInt((String)PropertiesMgr.get("initTankCount"));
		
		for(int i=0;i<initTankCount;i++) {
			add(new Tank(50 + i*80, 200, Dir.DOWN, this,Group.BAD));
		}
		
	}
	
	public void paint(Graphics g) {
		myTank.paint(g);
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.setColor(c);
		
		for(int i=0;i<objects.size();i++) {
			objects.get(i).paint(g);
		}
		
		
		for(int i = 0; i < objects.size(); i++) {
			for(int j=i+1; j<objects.size();j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				chain.collide(o1, o2);
			}
		}
		
		
		
	}

	public Tank getMainTank() {
		return myTank;
	}

}
