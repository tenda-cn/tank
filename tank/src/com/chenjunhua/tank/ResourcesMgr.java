package com.chenjunhua.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
public class ResourcesMgr {
	public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
	public static BufferedImage badTankL, badTankU, badTankR, badTankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];
	static {
		try {
			badTankU = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badTankL = ImageUtil.rotateImage(badTankU,  -90);
			badTankR = ImageUtil.rotateImage(badTankU,   90);
			badTankD =	ImageUtil.rotateImage(badTankU,  180);
			
			goodTankU = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodTankL = ImageUtil.rotateImage(goodTankU,  -90);
			goodTankR = ImageUtil.rotateImage(goodTankU,   90);
			goodTankD =	ImageUtil.rotateImage(goodTankU,  180);
		
			bulletU = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			bulletD = ImageUtil.rotateImage(bulletU,  180);
			bulletL = ImageUtil.rotateImage(bulletU,  -90);
			bulletR = ImageUtil.rotateImage(bulletU,   90);
			
		
			for(int i=0;i<16;i++)
				explodes[i] = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/e" +(i+1)+".gif"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
