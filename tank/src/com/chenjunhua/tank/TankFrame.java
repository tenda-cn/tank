package com.chenjunhua.tank;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	int x=100,y=100;
	
	
	public TankFrame() {
		setSize(800,600);
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
		System.out.println("paint");
		g.fill3DRect(x, y, 50, 50, true);
		x += 10;
	}
	
	class MyKeyListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent arg0) {
			x += 10;
			//repaint();
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			System.out.println("Key release");
		}
		
	}
}
