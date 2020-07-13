package com.chenjunhua.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(800,600);
		f.setResizable(false);
		f.setTitle("tank war");
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}});	
	}

}
