package com.swx.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rodking
 * @des 游戏服务启动类
 * 
 */
public class GServer extends AbsServer {
	private static Logger logger = LoggerFactory.getLogger(GServer.class);
	static final ChannelGroup allChannels = new DefaultChannelGroup(
			"time-server");
	public static GServer instance;
	private ServerBootstrap bootstrap;

	private GServer() {
	}

	public static GServer getInstance() {
		if (null == instance)
			instance = new GServer();

		return instance;
	}

	public boolean init() {
		return true;
	}

	public void start() {
		String serverPort = "9000";//GameMaster.getInstance().getProperty("serverPort");

		bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
				Executors.newCachedThreadPool(),
				Executors.newCachedThreadPool()));

		// 通信服务器管道工厂
		GServerPipelineFactory factory = new GServerPipelineFactory();

		bootstrap.setPipelineFactory(factory);

		bootstrap.setOption("child.receiveBufferSize", 8 * 1024);
		// 设置相关参数
		bootstrap.setOption("child.tcpNoDelay", true);
		// 设置相关参数
		bootstrap.setOption("child.keepAlive", true);

		Channel channel = bootstrap.bind(new InetSocketAddress(Integer
				.parseInt(serverPort)));
		allChannels.add(channel);

		logger.info(" [GS] 服务器Socket监听启动，端口为：" + Integer.parseInt(serverPort));
		
	}

}
