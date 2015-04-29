package com.swx.server;

public class BootServer {
	public static void main(String[] args) {
		// 游戏对象管理
		ObjectManager.getInstance().init();
		
		// 启动游戏服务器
		GServer.getInstance().init();
		GServer.getInstance().start();
		
		GMServer.getInstance().init();
		GMServer.getInstance().start();
	}
}
