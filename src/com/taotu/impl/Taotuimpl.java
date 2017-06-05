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
	 * 默认的抓取方法，最多会尝试 {@link ITaotuSpider#MAX_TRY_TIMES} 次下载
	 * @param url
	 * @return
	 * @throws Exception
	 */
	protected ArrayList<Taotu> getsTaotuList(String url) throws Exception {
		return getsTaotuList(url, ITaotuSpider.MAX_TRY_TIMES);
	}
	/**
	 * 通过url获取图片列表
	 * @param url
	 * @param maxTryTimes 最大尝试次数
	 * @return
	 */
	public ArrayList<Taotu> getsTaotuList(String url,Integer maxTryTimes) {
		maxTryTimes = maxTryTimes == null ? ITaotuSpider.MAX_TRY_TIMES : maxTryTimes;
		for (int i = 0; i < maxTryTimes ; i++) {
			System.err.println("开始第"+(i+1)+"次尝试获取图片列表！！");
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
			if (imgSelector == null || titleUrlSelector == null || dateSelector == null  ) throw new RuntimeException(TaotuSiteEnum.getEnumByUrl(url).getUrl() + ",url=" + url + "目前不支持获取图片列表");
			if (imgSelector != null || titleUrlSelector != null || dateSelector != null ) {
			Elements as = doc.select(imgSelector);
			Elements asa = doc.select(titleUrlSelector);
			Elements dateas = doc.select(dateSelector);
			Elements tags = doc.select(tagsSelector);	
			int a = 0; 
			System.out.println("正在获取网站：【"+url+"】的图片信息，共计：【"+asa.size()+"】组！！");
			if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MM2.getUrl()){
				for(Element elss: asa){
					System.out.println("正在获取网站：【"+url+"】的第【"+(a+1)+"/"+asa.size()+"】组的图片。");
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
					System.out.println("正在获取网站：【"+url+"】的第【"+(a+1)+"/"+asa.size()+"】组的图片。");
					Taotu taotu = new Taotu();
					if(DbUtil.isindb(StringUtil.Base64encode(elss.absUrl("href")))){
						continue;
					}else{					
					taotu.setTitle(elss.text());
					taotu.setUrl(elss.absUrl("href"));
					taotu.setImgUrl(as.get(a).absUrl("src"));
					taotu.setTagsName("丝袜美腿");
					taotu.setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu.setAddTime(elss.text().substring(elss.text().indexOf("[",3)-11,elss.text().indexOf("[",3)).replace(".", "-"));
					taotu.setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					taoTuList.add(taotu);
					}
					
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.BeautylegMM.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.DiSi8.getUrl()){
				for(Element elss: asa){
					System.out.println("正在获取网站：【"+url+"】的第【"+(a+1)+"/"+asa.size()+"】组的图片。");
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
					System.out.println("正在获取网站：【"+url+"】的第【"+(a+1)+"/"+asa.size()+"】组的图片。");
					Taotu taotu = new Taotu();
					if(DbUtil.isindb(StringUtil.Base64encode(elss.absUrl("href")))){
						continue;
					}else{
					taotu.setTitle(elss.text());
					taotu.setUrl(elss.absUrl("href"));
					taotu.setTagsName("美图图片");
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
					System.out.println("正在获取网站：【"+url+"】的第【"+(a+1)+"/"+asa.size()+"】组的图片。");
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
					System.out.println("正在获取网站：【"+url+"】的第【"+(a+1)+"/"+asa.size()+"】组的图片。");
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
					System.out.println("正在获取网站：【"+url+"】的第【"+(a+1)+"/"+asa.size()+"】组的图片。");
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
				System.out.println("啊哦！对不起，网站：【"+url+"】该站点信息目前尚未支持采集！！");
				}
			}
			return taoTuList;
		} catch (Exception e) {
			System.err.println(url + ",尝试了【" +(i+1)+"/" +maxTryTimes + "】次依然获取失败了！");
			}
		}
		throw new RuntimeException(url + ",尝试了" + maxTryTimes + "次依然获取失败了！");
	}
	
}
