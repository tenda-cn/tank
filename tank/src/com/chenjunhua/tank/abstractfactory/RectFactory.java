package com.chenjunhua.tank.abstractfactory;

import com.chenjunhua.tank.Dir;
import com.chenjunhua.tank.Group;
import com.chenjunhua.tank.TankFrame;

public class RectFactory extends GameFactory {

	@Override
	public BaseTank createBaseTank(int x, int y, Dir dir, Group group, TankFrame tf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseExplode creatExplode(int x, int y, TankFrame tf) {
		return new RectExplode(x, y, tf);
	}

	@Override
	public BaseBullet createBullet(int x, int y, TankFrame tf) {
		// TODO Auto-generated method stub
		return null;
	}

}
