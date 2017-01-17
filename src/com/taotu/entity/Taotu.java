package com.taotu.entity;

public class Taotu {
	private String title;
	private String url;
	private String imgUrl;
	private String tagsName;
	private String typeName;
	private String addTime;
	private String crawlTime;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * @return the addTime
	 */
	public String getAddTime() {
		return addTime;
	}
	/**
	 * @param addTime the addTime to set
	 */
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	
	/**
	 * @return the crawlTime
	 */
	public String getCrawlTime() {
		return crawlTime;
	}
	/**
	 * @param crawlTime the crawlTime to set
	 */
	public void setCrawlTime(String crawlTime) {
		this.crawlTime = crawlTime;
	}
	/**
	 * @return the tagsName
	 */
	public String getTagsName() {
		return tagsName;
	}
	/**
	 * @param tagsName the tagsName to set
	 */
	public void setTagsName(String tagsName) {
		this.tagsName = tagsName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Taotu [title=" + title + ", url=" + url + ", imgUrl=" + imgUrl + ", tagsName=" + tagsName
				+ ", typeName=" + typeName + ", addTime=" + addTime + ", crawlTime=" + crawlTime + "]";
	}
	
	
	
}
