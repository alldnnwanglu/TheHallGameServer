package com.swx.DBActor;

import akka.actor.UntypedActor;

public class DBActor extends UntypedActor
{
	
	private void init() {
		// TODO Auto-generated method stub
		
		// 这里创建表
	}
	
	
	@Override
	public void preStart() throws Exception {
		// TODO Auto-generated method stub
		super.preStart();
		
		init();
	
	}
	

	@Override
	public void postStop() throws Exception {
		// TODO Auto-generated method stub
		super.postStop();
	}


	@Override
	public void onReceive(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
