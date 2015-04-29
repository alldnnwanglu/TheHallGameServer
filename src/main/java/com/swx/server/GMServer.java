package com.swx.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rodking
 * @des    GM 命令控制面板
 *
 */
public class GMServer extends AbsServer {
	private static Logger logger = LoggerFactory.getLogger(GServer.class);
	public static GMServer instance;

	private GMServer() {
	}

	public static GMServer getInstance() {

		if (null == instance)
			instance = new GMServer();
		return instance;
	}

	public boolean init() {
		return true;
	}

	public void start() {
		logger.info(" [GM] 服务器已经已经启动:" + new Date());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			logger.info(" [GM] 输入命令:<start/stop/help(了解更多指令)>");
			try {
				String str = br.readLine().trim();
				if (str.equals("start")) {
					logger.info(" [GM] 服务器正在运行");
				} else if (str.equals("stop")) {
					GMServer.getInstance().stop();
					logger.info(" [GM] 服务器已经安全关闭:" + (new Date()).toString());
					break;
				} else { // 有业务处处理
					GMServer.getInstance().doSomething(str);
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(" [GM] 执行命令失败:遇到致命错误");
			}
		}

		System.exit(0);
	}

}
