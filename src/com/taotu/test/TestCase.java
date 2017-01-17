package com.taotu.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.taotu.entity.Taotu;
import com.taotu.entity.TaotuDetail;
import com.taotu.impl.GetAllImgboxsModel;
import com.taotu.impl.GetAllUrls;
import com.taotu.impl.TaotuDetailimpl;
import com.taotu.impl.Taotuimpl;
import com.taotu.util.AbstractSpider;
import com.taotu.util.StringUtil;


public class TestCase extends AbstractSpider{
	@Test
	public void testBeautyleg() throws Exception{
		String url = "http://www.beautylegmm.com/";
		String result = crawl(url);
		Document doc = Jsoup.parse(result);
		doc.setBaseUri(url);
		Elements as = doc.select(".post_weidaopic a img");
		Elements asa = doc.select(".post_weidaopic .post_weidaopic_title a");
		Taotu taotu = new Taotu();
		int a = 0;
		for(Element elss: asa){
			taotu.setTitle(elss.text());
			taotu.setUrl(elss.absUrl("href"));
			taotu.setImgUrl(as.get(a).absUrl("src"));
			a++;
			System.out.println(taotu);
		}
	}
	
	@Test
	public void testMeinvnvshen() throws Exception{
		String url = "http://www.zngirls.com/tag/neidi";
		String result = crawl(url);
		Document doc = Jsoup.parse(result);
		doc.setBaseUri(url);
		Elements as = doc.select(".b-tmb a img");
		Elements asa = doc.select(".b-tmb ul a");
		Taotu taotu = new Taotu();
		int a = 0;
		for(Element elss: asa){
			taotu.setTitle(elss.text());
			taotu.setUrl(elss.absUrl("href"));
			taotu.setImgUrl(as.get(a).absUrl("data-original"));
			a++;
			System.out.println(taotu);
		}
	}
	
	@Test
	public void testMeinv() throws Exception{
		String url = "http://www.zngirls.com/gallery/xinggan/";
		String result = crawl(url);
		Document doc = Jsoup.parse(result);
		doc.setBaseUri(url);
		Elements as = doc.select(".galleryli_div .galleryli_link img");
		Elements asa = doc.select(".galleryli_title a");
		Taotu taotu = new Taotu();
		int a = 0;
		for(Element elss: asa){
			taotu.setTitle(elss.text());
			taotu.setUrl(elss.absUrl("href"));
			taotu.setImgUrl(as.get(a).absUrl("data-original"));
			a++;
			System.out.println(taotu);
		}
	}
	
	@Test
	public void testMeiTuLu() throws Exception{
		String url = "http://www.meitulu.com/t/weimei/";
		String result = crawl(url);
		Document doc = Jsoup.parse(result);
		doc.setBaseUri(url);
		Elements as = doc.select("li a img");
		Elements asa = doc.select(".p_title a");
		Taotu taotu = new Taotu();
		int a = 0;
		for(Element elss: asa){
			taotu.setTitle(elss.text());
			taotu.setUrl(elss.absUrl("href"));
			taotu.setImgUrl(as.get(a).absUrl("src"));
			a++;
			System.out.println(taotu);
		}
	}
	
	@Test
	public void testRouSi365() throws Exception{
		String url = "http://www.rosi365.com/rosi/rosi/page/210";
		String result = crawl(url);
		Document doc = Jsoup.parse(result);
		doc.setBaseUri(url);
		Elements as = doc.select(".post");
		Elements asa = doc.select(".postimg a");
		Taotu taotu = new Taotu();
		int a = 0;
		for(Element elss: asa){
			taotu.setTitle(elss.text());
			taotu.setUrl(elss.absUrl("href"));
			taotu.setImgUrl(StringUtil.betweenSting(as.get(a).toString(), "url('", "')").replace("amp;", ""));
			a++;
			System.out.println(taotu);
		}
	}
	
	@Test
	public void MM2() throws Exception{
		String url = "http://www.2mmei.net/ns";
		String result = crawl(url);
		Document doc = Jsoup.parse(result);
		doc.setBaseUri(url);
		Elements as = doc.select("#ka");
		Elements asa = doc.select("#ha");
		Taotu taotu = new Taotu();
		int a = 0;
		for(Element elss: asa){
			taotu.setTitle(elss.attr("title"));
			taotu.setUrl(elss.absUrl("href"));
			taotu.setImgUrl(as.get(a).absUrl("name"));
			a++;
			System.out.println(taotu);
		}
	}
	
	
	@Test
	public void testGetTaotuList(){
		Taotuimpl beli = new Taotuimpl();
		Taotu[] taotu = beli.getsTaotuList("http://www.beautylegmm.com",10);
		int a=0;
		for(Taotu ts : taotu){
			System.out.println((a+1)+":"+ts);
			a++;
		}
	}
	
	@Test
	public void testGetTime(){
		Date date = new Date();
	    long times = date.getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String dateString = formatter.format(times);
	    System.out.println(dateString);

	}
	@Test
	public void testGetNowTime(){
		String a = StringUtil.getNowTime("yyyy-MM-dd");
		System.out.println(a);
	}
	
	@Test
	public void testGetTaotuDetail(){
		TaotuDetailimpl taotuDetail = new TaotuDetailimpl();
		TaotuDetail taotudetail = taotuDetail.getImgsBox("http://www.meitulu.com/item/6021.html",10);
		System.out.println(taotudetail);
	}
	
	@Test
	public void testGetAllWebSitesUrls(){
		GetAllUrls gets = new GetAllUrls();
		String siteurls = "";
		try {
			siteurls = gets.getWebsiteUrls();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FileUtil.contentToTxt("D:/siteurls.txt", siteurls);
	}
	
	
}
