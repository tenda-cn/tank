package com.chenjunhua.tank;

public class FourDirFireStrategy implements FireStrategy {
private static FourDirFireStrategy instance = new FourDirFireStrategy();
	
	private FourDirFireStrategy() {
	} 
	
	public static FourDirFireStrategy getInstance() {
		return instance;
	}
	
	@Override
	public void fire(Tank tank) {
		int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		
		Dir[] dirs = Dir.values();
		for(Dir dir: dirs)
			new Bullet(bX, bY, dir, tank.tf, tank.getGroup());
		
		if(tank.getGroup() == Group.GOOD)
			new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}
}
