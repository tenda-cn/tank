package com.chenjunhua.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertiesMgr {
	
	static Properties props = new Properties();

	private PropertiesMgr() {
	}
	
	static {
		try {
			props.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Object get(String key) {
		if(props == null) return null;
		return props.get(key);
		
	}
	public static void main(String [] args) {
		System.out.println(PropertiesMgr.get("initTankCount"));
	}
}
