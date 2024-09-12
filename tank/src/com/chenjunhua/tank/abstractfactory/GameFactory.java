package com.chenjunhua.tank.abstractfactory;

import com.chenjunhua.tank.Dir;
import com.chenjunhua.tank.Group;
import com.chenjunhua.tank.TankFrame;

public abstract class GameFactory {
	public abstract BaseTank createBaseTank(int x, int y, Dir dir, Group group, TankFrame tf);
	public abstract BaseExplode creatExplode(int x,int y, TankFrame tf);
	public abstract BaseBullet createBullet(int x, int y, TankFrame tf);

}
