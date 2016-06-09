package com.e2edour.app.engine.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import com.e2edour.app.engine.thread.FetcherThread;

/**
 * 定时调度器 
 * @author King
 */
public class Scheduler {
	@Autowired
	private  FetcherThread fetcherThread;
	/**
	 * 定时抓取网页面容
	 */
	public void fetcher(){
		fetcherThread.doFetcher();
	}


}
