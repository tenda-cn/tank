package com.chenjunhua.tank;

public class T {
	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
		for(int i=0;i<5;i++) {
			tf.tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, tf));
		}
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
		
	
	}

}
