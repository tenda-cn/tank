package com.chenjunhua.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
public class ResourcesMgr {
	public static BufferedImage tankL, tankU, tankR, tankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];
	static {
		try {
			tankU = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			tankL = ImageUtil.rotateImage(tankU,  -90);
			tankR = ImageUtil.rotateImage(tankU,   90);
			tankD =	ImageUtil.rotateImage(tankU,  180);
		
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
