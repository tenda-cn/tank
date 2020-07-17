package com.chenjunhua.tank;

public class CommonFireStrategy implements FireStrategy {
	
	private static CommonFireStrategy instance = new CommonFireStrategy();
	
	private  CommonFireStrategy() {
	}
	
	public static CommonFireStrategy getInstance() {
		return instance;
	}
	
	@Override
	public void fire(Tank tank) {
		int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		new Bullet(bX, bY, tank.getDir(), tank.tf, tank.getGroup());
		
		if(tank.getGroup() == Group.GOOD)
			new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}
}
