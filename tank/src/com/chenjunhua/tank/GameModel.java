package com.chenjunhua.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
	
	
	Tank myTank = new Tank(200, 400, Dir.DOWN, this,Group.GOOD);
	
	List<Bullet> bullets = new ArrayList<>();
	List<Tank> tanks = new ArrayList<Tank>();
	List<Explode> explodes = new ArrayList<Explode>();
	
	
	public GameModel() {

		int initTankCount =Integer.parseInt((String)PropertiesMgr.get("initTankCount"));
		
		for(int i=0;i<initTankCount;i++) {
			this.tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, this,Group.BAD));
		}
		
	}
	
	public void paint(Graphics g) {
		myTank.paint(g);
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹数量"+bullets.size(), 10, 60);
		g.drawString("敌人数量"+tanks.size(), 10, 80);
		g.setColor(c);
		
		for(int i=0;i<explodes.size();i++) {
			explodes.get(i).paint(g);
		}
		
		for(int i=0;i<bullets.size();i++) {
			bullets.get(i).paint(g);
		}
		
		for(int i=0;i<tanks.size();i++) {
			tanks.get(i).paint(g);
		}
		
		
		for(int i=0;i<bullets.size();i++) {
			for(int j = 0; j<tanks.size();j++ ) {
				bullets.get(i).collideWith(tanks.get(j));
			}
		}
		
	}

	public Tank getMainTank() {
		return myTank;
	}

}
