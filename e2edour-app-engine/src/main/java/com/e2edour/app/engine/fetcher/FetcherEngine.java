package com.e2edour.app.engine.fetcher;

public abstract class FetcherEngine implements Runnable {

	private String[] urls;

	public String[] getUrls() {
		return urls;
	}

	public void setUrls(String[] urls) {
		this.urls = urls;
	}

	abstract void fetcherAndParser(String[] urls);

}
