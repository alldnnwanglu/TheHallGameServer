package com.swx.server;

import org.apache.log4j.PropertyConfigurator;

/**
 * @author rodking
 * @version 0.0.1
 * @des 主要负责,管理游戏对象加载 csv,config etc.
 * 
 */
public class ObjectManager {
	private static ObjectManager instance;

	public static ObjectManager getInstance() {
		if (null == instance)
			instance = new ObjectManager();
		return instance;
	}

	private final String PATH = System.getProperty("user.dir")
			+ "/src/main/resource/log4j.properties";

	public boolean init() {
		PropertyConfigurator.configure(PATH);
		return true;
	}
}
