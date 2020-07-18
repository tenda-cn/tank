package com.chenjunhua.tank;

public class CommonFire implements FireStrategy {
	
	private static CommonFire instance = new CommonFire();
	
	private  CommonFire() {
	}
	
	public static CommonFire getInstance() {
		return instance;
	}
	
	@Override
	public void fire(Tank tank) {
		int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		new Bullet(bX, bY, tank.getDir(), tank.gm, tank.getGroup());
		
		if(tank.getGroup() == Group.GOOD)
			new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}
}
