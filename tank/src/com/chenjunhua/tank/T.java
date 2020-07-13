package com.chenjunhua.tank;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
	public static void main(String[] args) {
		TankFrame tf = new TankFrame();
		tf.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}});	
	}

}
