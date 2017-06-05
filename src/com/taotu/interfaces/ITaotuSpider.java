package com.taotu.interfaces;


/**
 * 获取某个站点的图册集合
 * @author Administrator
 *
 */
public interface ITaotuSpider {
	/**抓取页面失败重试次数*/
	public static final int MAX_TRY_TIMES = 5; 
	/**
	 * 通过一个url获取所有套图的实体
	 * @param url
	 * @param maxTryTimes 允许失败重试的次数
	 * @return
	 */
	public String getAllUrls(String url,Integer maxTryTimes);
	
}
