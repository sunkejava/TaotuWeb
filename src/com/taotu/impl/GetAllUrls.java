package com.taotu.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.taotu.entity.Taotu;
import com.taotu.enums.TaotuSiteEnum;
import com.taotu.util.AbstractSpider;
import com.taotu.util.NovelSpiderUtil;
import com.taotu.util.StringUtil;

public  class GetAllUrls extends AbstractSpider{
	/**
	 * ��ȡ����վ��ɲɼ���ַ
	 * @return
	 * @throws ParseException 
	 */
	public String getWebsiteUrls() throws ParseException{
		String webSitesresult = "";
		String[] webSites = new String[51];
		int a =-1;

		/**
		 * ͼƬ��֤���ƣ��޷��ɼ�
		 * webSites[++a]="http://www.disi8.com/disimulu/disi";
		 * webSites[++a]="http://www.rosi365.com/rosi/rosi";
		 */
		webSites[++a]="http://www.beautylegmm.com/";
		webSites[++a]="http://www.33mn.net/ns";
		webSites[++a]="http://www.meitulu.com/t/bomb.tv/";	
		webSites[++a]="http://www.meitulu.com/t/wpb-net/";	
		webSites[++a]="http://www.meitulu.com/t/ribenmeinv/";	
		webSites[++a]="http://www.meitulu.com/t/51modo/";	
		webSites[++a]="http://www.meitulu.com/t/tuigirl/";	
		webSites[++a]="http://www.meitulu.com/t/dgc/";	
		webSites[++a]="http://www.meitulu.com/t/mfstar/";	
		webSites[++a]="http://www.meitulu.com/t/4k-star/";	
		webSites[++a]="http://www.meitulu.com/t/uxing/";	
		webSites[++a]="http://www.meitulu.com/t/tgod/";	
		webSites[++a]="http://www.meitulu.com/t/bwh/";	
		webSites[++a]="http://www.meitulu.com/t/misty/";	
		webSites[++a]="http://www.meitulu.com/t/ugirls/";	
		webSites[++a]="http://www.meitulu.com/t/mistar/";	
		webSites[++a]="http://www.meitulu.com/t/taboo-love/";	
		webSites[++a]="http://www.meitulu.com/t/mygirl/";	
		webSites[++a]="http://www.meitulu.com/t/ysweb/";	
		webSites[++a]="http://www.meitulu.com/t/wbgc/";	
		webSites[++a]="http://www.meitulu.com/t/xiuren/";	
		webSites[++a]="http://www.meitulu.com/t/minisuka.tv/";	
		webSites[++a]="http://www.meitulu.com/t/sabra/";	
		webSites[++a]="http://www.meitulu.com/t/beautyleg-fanwaipian/";	
		webSites[++a]="http://www.meitulu.com/t/taiwanmeinv/";	
		webSites[++a]="http://www.meitulu.com/t/beautyleg/";	
		webSites[++a]="http://www.meitulu.com/t/imiss/";	
		webSites[++a]="http://www.meitulu.com/t/hpdigitalbooks/";	
		webSites[++a]="http://www.meitulu.com/t/ns-eyes/";	
		webSites[++a]="http://www.meitulu.com/t/bololi/";	
		webSites[++a]="http://www.meitulu.com/t/showtimedancer/";	
		webSites[++a]="http://www.meitulu.com/t/image.tv/";	
		webSites[++a]="http://www.meitulu.com/t/bwh/";	
		webSites[++a]="http://www.meitulu.com/t/for-side/";	
		webSites[++a]="http://www.meitulu.com/t/yingsihui-wings/";	
		webSites[++a]="http://www.meitulu.com/t/taboo-love/";	
		webSites[++a]="http://www.meitulu.com/t/minisuka.tv/";	
		webSites[++a]="http://www.meitulu.com/t/vyj/";	
		webSites[++a]="http://www.meitulu.com/t/aiyouwu/";	
		webSites[++a]="http://www.meitulu.com/t/ishow/";	
		webSites[++a]="http://www.meitulu.com/t/tyingart/";	
		webSites[++a]="http://www.meitulu.com/t/dianannan/";	
		webSites[++a]="http://www.meitulu.com/t/xingleyuan/";	
		webSites[++a]="http://www.meitulu.com/t/youmihui/";	
		webSites[++a]="http://www.meitulu.com/t/ligui/";	
		webSites[++a]="http://www.meitulu.com/t/youwuguan/";	
		webSites[++a]="http://www.meitulu.com/t/yunvlang/";	
		webSites[++a]="http://www.meitulu.com/t/x-tgirl/";	
		webSites[++a]="http://www.meitulu.com/t/chemo/";	
		webSites[++a]="http://www.meitulu.com/t/taste/";	
		webSites[++a]="http://www.meitulu.com/t/miitao/";
	//---------------------------------------------------------
//		webSites[++a]="http://www.meitulu.com/t/nvshen/";
//		webSites[++a]="http://www.meitulu.com/t/jipin/";
//		webSites[++a]="http://www.meitulu.com/t/nenmo/";
//		webSites[++a]="http://www.meitulu.com/t/wangluohongren/";
//		webSites[++a]="http://www.meitulu.com/t/fengsuniang/";
//		webSites[++a]="http://www.meitulu.com/t/qizhi/";
//		webSites[++a]="http://www.meitulu.com/t/youwu/";
//		webSites[++a]="http://www.meitulu.com/t/baoru/";
//		webSites[++a]="http://www.meitulu.com/t/xinggan/";
//		webSites[++a]="http://www.meitulu.com/t/youhuo/";
//		webSites[++a]="http://www.meitulu.com/t/meixiong/";
//		webSites[++a]="http://www.meitulu.com/t/shaofu/";
//		webSites[++a]="http://www.meitulu.com/t/changtui/";
//		webSites[++a]="http://www.meitulu.com/t/mengmeizi/";
//		webSites[++a]="http://www.meitulu.com/t/loli/";
//		webSites[++a]="http://www.meitulu.com/t/keai/";
//		webSites[++a]="http://www.meitulu.com/t/huwai/";
//		webSites[++a]="http://www.meitulu.com/t/bijini/";
//		webSites[++a]="http://www.meitulu.com/t/qingchun/";
//		webSites[++a]="http://www.meitulu.com/t/weimei/";
//		webSites[++a]="http://www.meitulu.com/t/qingxin/";
		int zongshu = 0;
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginTime = dfs.parse(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
		System.err.println("��ʼ�ɼ�����վ�����ݣ�");
		for(int i = 0;i<51;i++){
			System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���Ŀɲɼ����ݣ�");
			String webSite =webSites[i];
			String results;
			try {
				if(TaotuSiteEnum.getEnumUrl(webSite)==TaotuSiteEnum.MM2.getUrl()){
					results = crawl(webSite);
					Document doc = Jsoup.parse(results);
					doc.setBaseUri(webSite);
					Elements nextp = doc.select("#ys a");
					int sumnums = Integer.parseInt(nextp.get(nextp.size()-2).text());
					System.err.println("վ�㡾"+webSites[i]+"�������ݹ���"+sumnums+"ҳ��׼����ȡ����������");
					zongshu = zongshu+sumnums;
					for(int p = 1;p<=sumnums;p++){
						System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+p+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						String siteUrl = nextp.get(nextp.size()-2).absUrl("href").replace(nextp.get(nextp.size()-2).text(), Integer.toString(p));
						webSitesresult = webSitesresult + siteUrl + ",";
						//System.out.println(siteUrl);
						if(p==sumnums){
							System.err.println("վ�㡾"+webSites[i]+"�������ݲɼ���ϣ����ơ�"+sumnums+"���������ݣ��Ѳɼ�����"+p+"��������");
						}else{
							System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+(p+1)+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						}
					}
				}else if(TaotuSiteEnum.getEnumUrl(webSite)==TaotuSiteEnum.BeautylegMM.getUrl()){
					results = crawl(webSite);
					Document doc = Jsoup.parse(results);
					doc.setBaseUri(webSite);
					Elements nextp = doc.select(".page-navigator li a");
					int sumnums = Integer.parseInt(nextp.get(nextp.size()-2).text());
					System.out.println("Beautylegmm��ҳ��:"+sumnums);
					zongshu = zongshu+sumnums;
					System.err.println("վ�㡾"+webSites[i]+"�������ݹ���"+sumnums+"ҳ��׼����ȡ����������");
					for(int p = 1;p<=sumnums;p++){
						System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+p+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						String siteUrl = nextp.get(nextp.size()-2).absUrl("href").replace(nextp.get(nextp.size()-2).text(), Integer.toString(p));
						System.out.println("siteUrl:"+siteUrl);
						webSitesresult = webSitesresult + siteUrl + ",";
						if(p==sumnums){
							System.err.println("վ�㡾"+webSites[i]+"�������ݲɼ���ϣ����ơ�"+sumnums+"���������ݣ��Ѳɼ�����"+p+"��������");
						}else{
							System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+(p+1)+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						}
					}
				}else if(TaotuSiteEnum.getEnumUrl(webSite)==TaotuSiteEnum.DiSi8.getUrl()){
					results = crawl(webSite);
					Document doc = Jsoup.parse(results);
					doc.setBaseUri(webSite);
					Elements nextp = doc.select(".wp-pagenavi span");
					String soues = nextp.get(0).text().replace(" ", "").replace(" ", "");					
					Elements urlsp = doc.select(".wp-pagenavi a");
					int sumnums = Integer.parseInt(soues.substring(soues.length()-3, soues.length()-1));
					zongshu = zongshu+sumnums;
					System.err.println("վ�㡾"+webSites[i]+"�������ݹ���"+sumnums+"ҳ��׼����ȡ����������");
					for(int p = 1;p<=sumnums;p++){
						System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+p+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						String siteUrl = urlsp.get(2).absUrl("href").replace(urlsp.get(2).text(), Integer.toString(p));
						//System.out.println(siteUrl);
						webSitesresult = webSitesresult + siteUrl + ",";
						if(p==sumnums){
							System.err.println("վ�㡾"+webSites[i]+"�������ݲɼ���ϣ����ơ�"+sumnums+"���������ݣ��Ѳɼ�����"+p+"��������");
						}else{
							System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+(p+1)+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						}
					}
				}else if(TaotuSiteEnum.getEnumUrl(webSite)==TaotuSiteEnum.MeiNvTuPian.getUrl()){
					results = crawl(webSite);
					Document doc = Jsoup.parse(results);
					doc.setBaseUri(webSite);
					Elements nextp = doc.select(".pagesYY a");
					int sumnums;
					if(nextp.size()>1){
						sumnums = Integer.parseInt(nextp.get(nextp.size()-2).text());
					}else{
						sumnums = 1;
					}
					zongshu = zongshu+sumnums;
					System.err.println("վ�㡾"+webSites[i]+"�������ݹ���"+sumnums+"ҳ��׼����ȡ����������");
					for(int p = 1;p<=sumnums;p++){
						System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+p+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						String siteUrl;
						if(sumnums==1){
							siteUrl = nextp.get(nextp.size()-1).absUrl("href").replace(nextp.get(nextp.size()-1).text(), Integer.toString(p));
						}else{
							siteUrl = nextp.get(nextp.size()-2).absUrl("href").replace(nextp.get(nextp.size()-2).text(), Integer.toString(p));
						}
						//System.out.println(siteUrl);
						webSitesresult = webSitesresult + siteUrl + ",";
						if(p==sumnums){
							System.err.println("վ�㡾"+webSites[i]+"�������ݲɼ���ϣ����ơ�"+sumnums+"���������ݣ��Ѳɼ�����"+p+"��������");
						}else{
							System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+(p+1)+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						}
					}
				}else if(TaotuSiteEnum.getEnumUrl(webSite)==TaotuSiteEnum.MeiNvTuPianNvShen.getUrl()){
					results = crawl(webSite);
					Document doc = Jsoup.parse(results);
					doc.setBaseUri(webSite);
					Elements nextp = doc.select(".pagesYY a");
					int sumnums;
					if(nextp.size()>1){
						sumnums = Integer.parseInt(nextp.get(nextp.size()-1).text().replace("...", ""));
					}else{
						sumnums = 1;
					}
					zongshu = zongshu+sumnums;
					System.err.println("վ�㡾"+webSites[i]+"�������ݹ���"+sumnums+"ҳ��׼����ȡ����������");
					for(int p = 1;p<=sumnums;p++){
						System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+p+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						String siteUrl = nextp.get(nextp.size()-1).absUrl("href").replace(nextp.get(nextp.size()-1).text().replace("...", ""), Integer.toString(p));
						//System.out.println(siteUrl);
						webSitesresult = webSitesresult + siteUrl + ",";
						if(p==sumnums){
							System.err.println("վ�㡾"+webSites[i]+"�������ݲɼ���ϣ����ơ�"+sumnums+"���������ݣ��Ѳɼ�����"+p+"��������");
						}else{
							System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+(p+1)+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						}
					}
				}else if(TaotuSiteEnum.getEnumUrl(webSite)==TaotuSiteEnum.MeiTuLu.getUrl()){
					results = crawl(webSite);
					Document doc = Jsoup.parse(results);
					doc.setBaseUri(webSite);
					Elements nextp = doc.select(".text-c a");
					int sumnums;
					if(nextp.size()>1){
						sumnums = Integer.parseInt(nextp.get(nextp.size()-2).text());
					}else{
						sumnums = 1;
					}
					zongshu = zongshu+sumnums;
					System.err.println("վ�㡾"+webSites[i]+"�������ݹ���"+sumnums+"ҳ��׼����ȡ����������");
						for(int p = 1;p<=sumnums;p++){
							System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+p+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
							String siteUrl;
							if(p==1){
								siteUrl= webSite;
							}else{
								siteUrl= nextp.get(nextp.size()-2).absUrl("href").replace(nextp.get(nextp.size()-2).text(), Integer.toString(p));
							}
							//System.out.println(siteUrl);
							webSitesresult = webSitesresult + siteUrl + ",";
							if(p==sumnums){
								System.err.println("վ�㡾"+webSites[i]+"�������ݲɼ���ϣ����ơ�"+sumnums+"���������ݣ��Ѳɼ�����"+p+"��������");
							}else{
								System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+(p+1)+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
							}
						}
					
				}else if(TaotuSiteEnum.getEnumUrl(webSite)==TaotuSiteEnum.RouSi365.getUrl()){
					results = crawl(webSite);
					Document doc = Jsoup.parse(results);
					doc.setBaseUri(webSite);
					Elements nextp = doc.select(".wp-pagenavi span");
					String soues = nextp.get(0).text().replace(" ", "").replace(" ", "");					
					Elements urlsp = doc.select(".wp-pagenavi a");
					int sumnums = Integer.parseInt(soues.substring(soues.length()-4, soues.length()-1));
					zongshu = zongshu+sumnums;
					System.err.println("վ�㡾"+webSites[i]+"�������ݹ���"+sumnums+"ҳ��׼����ȡ����������");
					for(int p = 1;p<=sumnums;p++){
						System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+p+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						String siteUrl = urlsp.get(2).absUrl("href").replace(urlsp.get(2).text(), Integer.toString(p));
						//System.out.println(siteUrl);
						webSitesresult = webSitesresult + siteUrl + ",";
						if(p==sumnums){
							System.err.println("վ�㡾"+webSites[i]+"�������ݲɼ���ϣ����ơ�"+sumnums+"���������ݣ��Ѳɼ�����"+p+"��������");
						}else{
							System.err.println("���ڻ�ȡվ�㡾"+webSites[i]+"���ĵڡ�"+(p+1)+"/"+sumnums+"��ҳ�Ŀɲɼ����ݣ�");
						}
					}
				}else{
					webSitesresult = webSitesresult+"ERROR:" + "��Ŷ���Բ�����վ����"+webSite+"����վ����ϢĿǰ��δ֧�ֲɼ�����";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.err.println("����վ��ɲɼ���ַ��ȡ��ϣ�������ַ��Ϊ����"+zongshu+"����!!!");
		Date endTime = dfs.parse(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
		long between=(endTime.getTime()-beginTime.getTime())/1000;//����1000��Ϊ��ת������   
		long day1=between/(24*3600);   
		long hour1=between%(24*3600)/3600;   
		long minute1=between%3600/60;   
		long second1=between%60/60;   
		System.err.println("���βɼ����ƺ�ʱ��"+day1+"��"+hour1+"Сʱ"+minute1+"��"+second1+"��");
		
		return webSitesresult;
	}
	
	public Taotu[] getsTaotuListofWebSite(String url) {
		try {
			String result = super.crawl(url);
			Document doc = Jsoup.parse(result);
			doc.setBaseUri(url);
			Map<String,String> contexts=NovelSpiderUtil.getContext(TaotuSiteEnum.getEnumByUrl(url));
			String imgSelector = contexts.get("taotu-list-img-selector");
			String titleUrlSelector = contexts.get("taotu-list-titleurl-selector");
			String dateSelector = contexts.get("taotu-list-date-selector");
			Elements as = doc.select(imgSelector);
			Elements asa = doc.select(titleUrlSelector);
			Elements dateas = doc.select(dateSelector);
			Taotu[] taotu = new Taotu[as.size()];
			int a = 0;
			if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MM2.getUrl()){
				for(Element elss: asa){
					taotu[a] = new Taotu();
					taotu[a].setTitle(elss.attr("title"));
					taotu[a].setUrl(elss.absUrl("href"));
					taotu[a].setImgUrl(as.get(a).absUrl("name"));
					taotu[a].setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu[a].setAddTime(StringUtil.getNowTime("yyyy-MM-dd"));
					taotu[a].setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					a++;
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.MM2.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.BeautylegMM.getUrl()){
				for(Element elss: asa){
					taotu[a] = new Taotu();
					taotu[a].setTitle(elss.text());
					taotu[a].setUrl(elss.absUrl("href"));
					taotu[a].setImgUrl(as.get(a).absUrl("src"));
					taotu[a].setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu[a].setAddTime(elss.text().substring(elss.text().indexOf("[",3)-11,elss.text().indexOf("[",3)).replace(".", "-"));
					taotu[a].setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					a++;
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.BeautylegMM.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.DiSi8.getUrl()){
				for(Element elss: asa){
					taotu[a] = new Taotu();
					taotu[a].setTitle(elss.text());
					taotu[a].setUrl(elss.absUrl("href"));
					taotu[a].setImgUrl(StringUtil.betweenSting(as.get(a).toString(), "url('", "')").replace("amp;", ""));
					taotu[a].setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu[a].setAddTime(dateas.get(a).text().replace(".", "-"));
					taotu[a].setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					a++;
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.DiSi8.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MeiNvTuPian.getUrl()){
				for(Element elss: asa){
					taotu[a] = new Taotu();
					taotu[a].setTitle(elss.text());
					taotu[a].setUrl(elss.absUrl("href"));
					taotu[a].setImgUrl(as.get(a).absUrl("data-original"));
					taotu[a].setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu[a].setAddTime(StringUtil.getNowTime("yyyy-MM-dd"));
					taotu[a].setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					a++;
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.MeiNvTuPian.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MeiNvTuPianNvShen.getUrl()){
				for(Element elss: asa){
					taotu[a] = new Taotu();
					taotu[a].setTitle(elss.text());
					taotu[a].setUrl(elss.absUrl("href"));
					taotu[a].setImgUrl(as.get(a).absUrl("data-original"));
					taotu[a].setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu[a].setAddTime(StringUtil.getNowTime("yyyy-MM-dd"));
					taotu[a].setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					a++;
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.MeiNvTuPianNvShen.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MeiTuLu.getUrl()){
				for(Element elss: asa){
					taotu[a] = new Taotu();
					taotu[a].setTitle(elss.text());
					taotu[a].setUrl(elss.absUrl("href"));
					taotu[a].setImgUrl(as.get(a).absUrl("src"));
					taotu[a].setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu[a].setAddTime(StringUtil.getNowTime("yyyy-MM-dd"));
					taotu[a].setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					a++;
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.MeiTuLu.getUrl());
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.RouSi365.getUrl()){
				for(Element elss: asa){
					taotu[a] = new Taotu();
					taotu[a].setTitle(elss.text());
					taotu[a].setUrl(elss.absUrl("href"));
					taotu[a].setImgUrl(StringUtil.betweenSting(as.get(a).toString(), "url('", "')").replace("amp;", ""));
					taotu[a].setTypeName(TaotuSiteEnum.getEnumByUrl(url).toString());
					taotu[a].setAddTime(dateas.get(a).text().replace(".", "-"));
					taotu[a].setCrawlTime(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
					a++;
					
				}
				System.out.println(TaotuSiteEnum.getEnumUrl(url)+"----"+TaotuSiteEnum.RouSi365.getUrl());
			}else{
				taotu[a].setTitle("��Ŷ���Բ�����վ����"+url+"����վ����ϢĿǰ��δ֧�ֲɼ�����");
			}
			return taotu;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
