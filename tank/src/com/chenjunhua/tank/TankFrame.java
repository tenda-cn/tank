package com.chenjunhua.tank;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
	Tank myTank = new Tank(200, 400, Dir.DOWN, this,Group.GOOD);
	
	List<Bullet> bullets = new ArrayList<>();
	List<Tank> tanks = new ArrayList<Tank>();
	List<Explode> explodes = new ArrayList<Explode>();
	
	static final int GAME_WIDTH = 1080;
	static final int GAME_HEIGHT = 960;
	
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
		myTank.paint(g);
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹数量"+bullets.size(), 10, 60);
		g.drawString("敌人数量"+tanks.size(), 10, 80);
		g.setColor(c);
		
		for(int i=0;i<explodes.size();i++) {
			explodes.get(i).paint(g);
		}
		
		for(int i=0;i<bullets.size();i++) {
			bullets.get(i).paint(g);
		}
		
		for(int i=0;i<tanks.size();i++) {
			tanks.get(i).paint(g);
		}
		
		
		for(int i=0;i<bullets.size();i++) {
			for(int j = 0; j<tanks.size();j++ ) {
				bullets.get(i).collideWith(tanks.get(j));
			}
		}
		
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