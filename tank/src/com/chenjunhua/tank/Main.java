package com.chenjunhua.tank;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
		
		int initTankCount =Integer.parseInt((String)PropertiesMgr.get("initTankCount"));
		
		
		for(int i=0;i<initTankCount;i++) {
			tf.tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, tf,Group.BAD));
		}
		
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
		
	
	}

}
