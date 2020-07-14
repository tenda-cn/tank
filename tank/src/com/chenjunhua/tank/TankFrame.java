package com.chenjunhua.tank;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	Tank myTank = new Tank(200, 200, Dir.DOWN, this);
	Bullet bullet = new Bullet(300, 300, Dir.DOWN);
	static final int GAME_WIDTH = 800;
	static final int GAME_HEIGHT = 600;
	
	public TankFrame() {
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setResizable(false);
		setTitle("tank war");
		setVisible(true);
	
		this.addKeyListener(new MyKeyListener());
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		
	}
	@Override
	public void paint(Graphics g) {
		bullet.paint(g);
		myTank.paint(g);
	}
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) 
			offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
		Graphics goffScreenGraphics =offScreenImage.getGraphics();
		Color color = goffScreenGraphics.getColor();
		goffScreenGraphics.setColor(Color.black);
		goffScreenGraphics.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		goffScreenGraphics.setColor(color);
		paint(goffScreenGraphics);
		g.drawImage(offScreenImage, 0, 0, null);
		
	}
	
	
	
	class MyKeyListener extends KeyAdapter{
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			}
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			case KeyEvent.VK_CONTROL:
				myTank.fire();
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			myTank.setMoving(true);
			if(bL) myTank.setDir(Dir.LEFT);
			if(bU) myTank.setDir(Dir.UP);
			if(bR) myTank.setDir(Dir.RIGHT);
			if(bD) myTank.setDir(Dir.DOWN);
			if(!bD && !bR && !bL &&!bU)
				myTank.setMoving(false);
		}
		
	}
}