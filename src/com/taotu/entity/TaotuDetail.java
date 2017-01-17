package com.taotu.entity;

import java.util.Arrays;

public class TaotuDetail {
	private String[] urls;
	private String content;
	private String nextPage;
	private String prevPage;
	/**
	 * @return the urls
	 */
	public String getUrls() {
		String aurls = "";
		for(int i=0;i<urls.length;i++){
			if(i==urls.length-1){
				aurls = aurls+"\""+urls[i]+"\"";
			}else{
				aurls = aurls+"\""+urls[i]+"\""+",";
			}
		}
		return aurls;
	}
	
	/**
	 * @return the urls
	 */
	public String[] getUrlsp() {
		return urls;
	}
	/**
	 * @param urls the urls to set
	 */
	public void setUrls(String[] urls) {
		this.urls = urls;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the nextPage
	 */
	public String getNextPage() {
		return nextPage;
	}
	/**
	 * @param nextPage the nextPage to set
	 */
	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}
	/**
	 * @return the prevPage
	 */
	public String getPrevPage() {
		return prevPage;
	}
	/**
	 * @param prevPage the prevPage to set
	 */
	public void setPrevPage(String prevPage) {
		this.prevPage = prevPage;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TaotuDetail [urls=" + Arrays.toString(urls) + ", content=" + content + ", nextPage=" + nextPage
				+ ", prevPage=" + prevPage + "]";
	}


	
	
	
	
}
