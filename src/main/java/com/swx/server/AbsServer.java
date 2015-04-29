package com.swx.server;

/**
 * @author rodking
 * @des 服务端抽象接口
 */
public abstract class AbsServer {
	public boolean init(){return true;}
	
	public void start(){}
	
	public void stop(){}
	
	public void doSomething(String str){}
	
}
