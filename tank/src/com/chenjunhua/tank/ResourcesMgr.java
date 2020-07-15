package com.chenjunhua.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourcesMgr {
	public static BufferedImage tankL, tankU, tankR, tankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	static {
		try {
			tankL = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankU = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankR = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			tankD = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			bulletD = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			bulletL = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletR = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			bulletU = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
