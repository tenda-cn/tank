package com.chenjunhua.tank;
import java.awt.Frame;
import java.awt.Graphics;

public class TankFrame extends Frame {
	public TankFrame() {
		setSize(800,600);
		setResizable(false);
		setTitle("tank war");
		setVisible(true);
	}
	@Override
	public void paint(Graphics g) {
		g.fill3DRect(200, 200, 50, 50, true);
	}
	

}
