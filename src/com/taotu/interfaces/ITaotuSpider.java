package com.taotu.interfaces;


/**
 * ��ȡĳ��վ���ͼ�Ἧ��
 * @author Administrator
 *
 */
public interface ITaotuSpider {
	/**ץȡҳ��ʧ�����Դ���*/
	public static final int MAX_TRY_TIMES = 5; 
	/**
	 * ͨ��һ��url��ȡ������ͼ��ʵ��
	 * @param url
	 * @param maxTryTimes ����ʧ�����ԵĴ���
	 * @return
	 */
	public String getAllUrls(String url,Integer maxTryTimes);
	
}
