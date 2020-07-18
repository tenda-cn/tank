package com.chenjunhua.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import com.chenjunhua.tank.cor.ColliderChain;


public class GameModel {
	
	private static GameModel instance = new GameModel();
	
	ColliderChain chain =new ColliderChain();
	
	Tank myTank;
	
	List<GameObject> objects = new ArrayList<>(); 
		
	
	public static GameModel getInstance() {
		return instance;
	}
	
	
	public void add(GameObject object) {
		objects.add(object);
	}
	
	public void remove(GameObject object) {
		objects.remove(object); 
	}
	
	private GameModel() {

		int initTankCount =Integer.parseInt((String)PropertiesMgr.get("initTankCount"));
		
		myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);
		
		for(int i=0;i<initTankCount;i++) {
			add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD));
		}
		
		add(new Wall(150, 150, 200, 50));
		add(new Wall(550, 150, 200, 50));
		add(new Wall(300, 300, 50, 200));
		add(new Wall(550, 300, 50, 200));
		
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
