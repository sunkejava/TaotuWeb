package com.taotu.impl;

import java.util.ArrayList;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.taotu.entity.Taotu;
import com.taotu.enums.TaotuSiteEnum;
import com.taotu.interfaces.ITaotuSpider;
import com.taotu.util.AbstractSpider;
import com.taotu.util.DbUtil;
import com.taotu.util.NovelSpiderUtil;
import com.taotu.util.StringUtil;


public  class Taotuimpl extends AbstractSpider{
	
	
	/**
	 * Ĭ�ϵ�ץȡ���������᳢�� {@link ITaotuSpider#MAX_TRY_TIMES} ������
	 * @param url
	 * @return
	 * @throws Exception
	 */
	protected ArrayList<Taotu> getsTaotuList(String url) throws Exception {
		return getsTaotuList(url, ITaotuSpider.MAX_TRY_TIMES);
	}
	/**
	 * ͨ��url��ȡͼƬ�б�
	 * @param url
	 * @param maxTryTimes ����Դ���
	 * @return
	 */
	public ArrayList<Taotu> getsTaotuList(String url,Integer maxTryTimes) {
		maxTryTimes = maxTryTimes == null ? ITaotuSpider.MAX_TRY_TIMES : maxTryTimes;
		for (int i = 0; i < maxTryTimes ; i++) {
			System.err.println("��ʼ��"+(i+1)+"�γ��Ի�ȡͼƬ�б���");
		try {
			String result = super.crawl(url);
			Document doc = Jsoup.parse(result);
			doc.setBaseUri(url);
			Map<String,String> contexts=NovelSpiderUtil.getContext(TaotuSiteEnum.getEnumByUrl(url));
			String imgSelector = contexts.get("taotu-list-img-selector");
			String titleUrlSelector = contexts.get("taotu-list-titleurl-selector");
			String dateSelector = contexts.get("taotu-list-date-selector");
			String tagsSelector = contexts.get("taotu-list-tags-selector");
			ArrayList<Taotu> taoTuList = new ArrayList<Taotu>();
			if (imgSelector == null || titleUrlSelector == null || dateSelector == null  ) throw new RuntimeException(TaotuSiteEnum.getEnumByUrl(url).getUrl() + ",url=" + url + "Ŀǰ��֧�ֻ�ȡͼƬ�б�");
			if (imgSelector != null || titleUrlSelector != null || dateSelector != null ) {
			Elements as = doc.select(imgSelector);
			Elements asa = doc.select(titleUrlSelector);
			Elements dateas = doc.select(dateSelector);
			Elements tags = doc.select(tagsSelector);	
			int a = 0; 
			System.out.println("���ڻ�ȡ��վ����"+url+"����ͼƬ��Ϣ�����ƣ���"+asa.size()+"���飡��");
			if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MM2.getUrl()){
				for(Element elss: asa){
					System.out.println("���ڻ�ȡ��վ����"+url+"���ĵڡ�"+(a+1)+"/"+asa.size()+"�����ͼƬ��");
					Taotu taotu = new Taotu();
					if(DbUtil.isindb(StringUtil.Base64encode(elss.absUrl("href")))){
						continue;
					}else{
					taotu.setTitle(elss.attr("title"));
					taotu.setUrl(elss.absUrl("href"));
					taotu.setImgUrl(as.get(a).absUrl("name"));
					taotu.setTagsName("MM2");
					taotu.setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu.setAddTime(StringUtil.getNowTime("yyyy-MM-dd"));
					taotu.setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					taoTuList.add(taotu);
					}
				}
				
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.BeautylegMM.getUrl()){
				for(Element elss: asa){
					System.out.println("���ڻ�ȡ��վ����"+url+"���ĵڡ�"+(a+1)+"/"+asa.size()+"�����ͼƬ��");
					Taotu taotu = new Taotu();
					if(DbUtil.isindb(StringUtil.Base64encode(elss.absUrl("href")))){
						continue;
					}else{					
					taotu.setTitle(elss.text());
					taotu.setUrl(elss.absUrl("href"));
					taotu.setImgUrl(as.get(a).absUrl("src"));
					taotu.setTagsName("˿������");
					taotu.setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu.setAddTime(elss.text().substring(elss.text().indexOf("[",3)-11,elss.text().indexOf("[",3)).replace(".", "-"));
					taotu.setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					taoTuList.add(taotu);
					}
					
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.BeautylegMM.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.DiSi8.getUrl()){
				for(Element elss: asa){
					System.out.println("���ڻ�ȡ��վ����"+url+"���ĵڡ�"+(a+1)+"/"+asa.size()+"�����ͼƬ��");
					Taotu taotu = new Taotu();
					if(DbUtil.isindb(StringUtil.Base64encode(elss.absUrl("href")))){
						continue;
					}else{
					taotu.setTitle(elss.text());
					taotu.setUrl(elss.absUrl("href"));
					taotu.setTagsName(tags.get(a).text());
					taotu.setImgUrl(StringUtil.betweenSting(as.get(a).toString(), "url('", "')").replace("amp;", ""));
					taotu.setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu.setAddTime(dateas.get(a).text().replace(".", "-"));
					taotu.setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					taoTuList.add(taotu);
					}
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.DiSi8.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MeiNvTuPian.getUrl()){
				for(Element elss: asa){
					System.out.println("���ڻ�ȡ��վ����"+url+"���ĵڡ�"+(a+1)+"/"+asa.size()+"�����ͼƬ��");
					Taotu taotu = new Taotu();
					if(DbUtil.isindb(StringUtil.Base64encode(elss.absUrl("href")))){
						continue;
					}else{
					taotu.setTitle(elss.text());
					taotu.setUrl(elss.absUrl("href"));
					taotu.setTagsName("��ͼͼƬ");
					taotu.setImgUrl(as.get(a).absUrl("data-original"));
					taotu.setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu.setAddTime(StringUtil.getNowTime("yyyy-MM-dd"));
					taotu.setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					taoTuList.add(taotu);
					}
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.MeiNvTuPian.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MeiNvTuPianNvShen.getUrl()){
				for(Element elss: asa){
					System.out.println("���ڻ�ȡ��վ����"+url+"���ĵڡ�"+(a+1)+"/"+asa.size()+"�����ͼƬ��");
					Taotu taotu = new Taotu();
					if(DbUtil.isindb(StringUtil.Base64encode(elss.absUrl("href")))){
						continue;
					}else{
					taotu.setTitle(elss.text());
					taotu.setUrl(elss.absUrl("href"));
					taotu.setTagsName(tags.get(a).text());
					taotu.setImgUrl(as.get(a).absUrl("data-original"));
					taotu.setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu.setAddTime(StringUtil.getNowTime("yyyy-MM-dd"));
					taotu.setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					taoTuList.add(taotu);
					}
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.MeiNvTuPianNvShen.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MeiTuLu.getUrl()){
				for(Element elss: asa){
					System.out.println("���ڻ�ȡ��վ����"+url+"���ĵڡ�"+(a+1)+"/"+asa.size()+"�����ͼƬ��");
					Taotu taotu = new Taotu();
					if(DbUtil.isindb(StringUtil.Base64encode(elss.absUrl("href")))){
						continue;
					}else{
					taotu.setTitle(elss.text());
					taotu.setUrl(elss.absUrl("href"));
					taotu.setImgUrl(as.get(a).absUrl("src"));
					taotu.setTagsName(tags.get(a).text());
					taotu.setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu.setAddTime(StringUtil.getNowTime("yyyy-MM-dd"));
					taotu.setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					taoTuList.add(taotu);
					}
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.MeiTuLu.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.RouSi365.getUrl()){
				for(Element elss: asa){
					System.out.println("���ڻ�ȡ��վ����"+url+"���ĵڡ�"+(a+1)+"/"+asa.size()+"�����ͼƬ��");
					Taotu taotu = new Taotu();
					if(DbUtil.isindb(StringUtil.Base64encode(elss.absUrl("href")))){
						continue;
					}else{
					taotu.setTitle(elss.text());
					taotu.setUrl(elss.absUrl("href"));
					taotu.setTagsName(tags.get(a).text());
					taotu.setImgUrl(StringUtil.betweenSting(as.get(a).toString(), "url('", "')").replace("amp;", ""));
					taotu.setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu.setAddTime(dateas.get(a).text().replace(".", "-"));
					taotu.setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					taoTuList.add(taotu);
					}
					
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.RouSi365.getUrl());
			}else{
				System.out.println("��Ŷ���Բ�����վ����"+url+"����վ����ϢĿǰ��δ֧�ֲɼ�����");
				}
			}
			return taoTuList;
		} catch (Exception e) {
			System.err.println(url + ",�����ˡ�" +(i+1)+"/" +maxTryTimes + "������Ȼ��ȡʧ���ˣ�");
			}
		}
		throw new RuntimeException(url + ",������" + maxTryTimes + "����Ȼ��ȡʧ���ˣ�");
	}
	
}
