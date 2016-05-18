package com.e2edour.app.engine.thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.e2edour.app.facade.FetcherFacade;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.e2edour.app.engine.fetcher.FetcherEngine;
import com.e2edour.app.facade.bean.FetcherIndexBO;

@Component
public class FetcherThread implements ApplicationContextAware {

	private ExecutorService threadPool = Executors.newCachedThreadPool(); // 线程池

	@Autowired
	private FetcherFacade fetcherFacade;

	public void doFetcher() {
		List<FetcherIndexBO> fetchers = fetcherFacade.getFetcherIndexs();
		for (FetcherIndexBO o : fetchers) {
			FetcherEngine engine = (FetcherEngine) applicationContext.getBean(o
					.getClassName());
			engine.setUrls(o.getUrls());
			threadPool.execute(engine);
		}
	}
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	private ApplicationContext applicationContext;
}
