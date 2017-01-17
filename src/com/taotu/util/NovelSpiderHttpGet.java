package com.taotu.util;

import java.net.URI;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;

public class NovelSpiderHttpGet extends HttpGet {

	public NovelSpiderHttpGet() {
	}

	public NovelSpiderHttpGet(URI uri) {
		super(uri);
	}

	public NovelSpiderHttpGet(String uri) {
		super(uri);
		setDefaultConfig();
	}
	
	
	private void setDefaultConfig(){
		this.setConfig(RequestConfig.custom()
				.setSocketTimeout(1000*60*5)
				.setMaxRedirects(1000*60*5)
				.setConnectTimeout(1000*60*10)
				.setConnectionRequestTimeout(1000*60*5).build());
		this.setHeader("User-Agent","NovelSpider");
	}

}
