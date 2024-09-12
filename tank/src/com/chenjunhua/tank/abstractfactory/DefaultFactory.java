package com.chenjunhua.tank.abstractfactory;

import com.chenjunhua.tank.Dir;
import com.chenjunhua.tank.Explode;
import com.chenjunhua.tank.Group;
import com.chenjunhua.tank.TankFrame;

public class DefaultFactory extends GameFactory {

	@Override
	public BaseTank createBaseTank(int x, int y, Dir dir, Group group, TankFrame tf) {
		return null;
	}

	@Override
	public BaseExplode creatExplode(int x, int y, TankFrame tf) {
		return new Explode(x, y, tf);
	}

	@Override
	public BaseBullet createBullet(int x, int y, TankFrame tf) {
		return null;
	}
	
}
