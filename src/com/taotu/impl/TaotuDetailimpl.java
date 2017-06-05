package com.taotu.impl;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.taotu.entity.TaotuDetail;
import com.taotu.enums.TaotuSiteEnum;
import com.taotu.util.AbstractSpider;
import com.taotu.util.NovelSpiderUtil;
import com.taotu.util.StringUtil;

public class TaotuDetailimpl extends AbstractSpider{
	
	/**
	 * ͨ��url��ȡ��ϸͼƬ
	 * @param url
	 * @param maxTryTimes ����Դ���
	 * @return
	 */
	public TaotuDetail getsTaotuDetail(String url,Integer maxTryTimes) {
		for (int is = 0; is < maxTryTimes ; is++) {
			System.err.println("��ʼ��"+(is+1)+"�γ��Ի�ȡͼƬ�б���");
			maxTryTimes = maxTryTimes == null ? 3 : maxTryTimes;
		try {
			String result = super.crawl(url);
			Document doc = Jsoup.parse(result);
			doc.setBaseUri(url);
			Map<String,String> contexts=NovelSpiderUtil.getContext(TaotuSiteEnum.getEnumByUrl(url));
			String contentSelector = contexts.get("taotu-detail-content-selector") == "" ? "û�ж�Ӧ�ļ�����ݣ�������˼" : contexts.get("taotu-detail-content-selector");
			String imgsSelector = contexts.get("taotu-detail-imgs-selector");
			Elements contentElements = doc.select(contentSelector);
			Elements contentElements2 = doc.select(".c_l");
			Elements imgsElements = doc.select(imgsSelector);
			TaotuDetail taotudetail = new TaotuDetail();
			int a = 0;
			if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MM2.getUrl()){
				taotudetail.setContent("2mm����"+contentElements.text()+"��");
				String[] resulturls = new String[imgsElements.size()];
				System.out.println("���ڻ�ȡ��վ����"+url+"����ͼƬ���ϣ����ƣ���"+imgsElements.size()+"����ͼƬ����");
				for(Element els : imgsElements){
					resulturls[a] = els.absUrl("name");
					a++;
				}
				taotudetail.setUrls(resulturls);
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.BeautylegMM.getUrl()){
				taotudetail.setContent(contentElements.text());
				System.out.println("��飺"+contentElements.text());
				String pagesSelector = contexts.get("taotu-detail-pages-selector");
				Elements pagesElements = doc.select(pagesSelector);
				int sumnums = Integer.parseInt(pagesElements.text().substring(pagesElements.text().indexOf("[",3)+1, pagesElements.text().length()-2));
				System.out.println("��ҳ����"+sumnums);
				String firstImgUrl = imgsElements.get(0).absUrl("href");
				System.out.println("���ڻ�ȡ��վ����"+url+"����ͼƬ���ϣ����ƣ���"+sumnums+"����ͼƬ����");
				String[] resulturls = new String[sumnums];
				for(int i =0;i< sumnums;i++){
					System.out.println(firstImgUrl);
					if(i<10){
						resulturls[i] = firstImgUrl.replace("0000", "000"+Integer.toString(i));
					}else if(i<100 && i> 9){
						resulturls[i] = firstImgUrl.replace("0000", "00"+Integer.toString(i));
					}else{
						resulturls[i] = firstImgUrl.replace("0000", "0"+Integer.toString(i));
					}
					
				}
				taotudetail.setUrls(resulturls);
				
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.DiSi8.getUrl()){
				Elements consElements = doc.select("h3 a");
				taotudetail.setContent("����ӡ�󣺡�"+consElements.text()+"��");
				String[] resulturls = new String[imgsElements.size()/2];
				System.out.println("���ڻ�ȡ��վ����"+url+"����ͼƬ���ϣ����ƣ���"+imgsElements.size()/2+"����ͼƬ����");
				for(Element els : imgsElements){
					if(a<imgsElements.size()/2){
					resulturls[a] = els.absUrl("href").replace("www.disi8.com", "disi.8007077168.com/disi8").replace("thumbs/thumbs_", "");
					}else{
						break;
					}
					a++;
				}
				taotudetail.setUrls(resulturls);
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MeiNvTuPian.getUrl()){
				taotudetail.setContent("��ŮͼƬ-Ů�񣺡�"+contentElements.text()+"��");
				String prevSelector = contexts.get("taotu-detail-prev-selector");
				Elements prevElements = doc.select(prevSelector);
				taotudetail.setPrevPage(StringUtil.Base64encode(prevElements.get(0).absUrl("href")));
				taotudetail.setNextPage(StringUtil.Base64encode(prevElements.get(1).absUrl("href")));
				String urlsp=prevElements.get(1).absUrl("href");
				String[] resulturls = new String[imgsElements.size()];
				System.out.println("���ڻ�ȡ��վ����"+url+"����ͼƬ���ϣ����ƣ���"+imgsElements.size()+"����ͼƬ����");
				for(Element els : imgsElements){
					resulturls[a] = els.absUrl("src");
					a++;
				}
				if(urlsp == null || urlsp == "" || urlsp.indexOf("html")<0){
					
				}else{
					
					TaotuDetailimpl taotuDetail = new TaotuDetailimpl();
					TaotuDetail taotudetails = taotuDetail.getImgsBox(urlsp,10);
					String[] aps = taotudetails.getUrlsp();
					resulturls = StringUtil.concat(resulturls, aps);
				}
				taotudetail.setUrls(resulturls);
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MeiNvTuPianNvShenp.getUrl()){
				taotudetail.setContent("��ŮͼƬ-Ů�񣺡�"+contentElements.text()+"��");
				String prevSelector = contexts.get("taotu-detail-prev-selector");
				Elements prevElements = doc.select(prevSelector);
				taotudetail.setPrevPage(StringUtil.Base64encode(prevElements.get(0).absUrl("href")));
				taotudetail.setNextPage(StringUtil.Base64encode(prevElements.get(1).absUrl("href")));
				String urlsp=prevElements.get(1).absUrl("href");
				String[] resulturls = new String[imgsElements.size()];
				System.out.println("���ڻ�ȡ��վ����"+url+"����ͼƬ���ϣ����ƣ���"+imgsElements.size()+"����ͼƬ����");
				for(Element els : imgsElements){
					resulturls[a] = els.absUrl("src");
					a++;
				}
				if(urlsp == null || urlsp == "" || urlsp.indexOf("html")<0){
					
				}else{
					
					TaotuDetailimpl taotuDetail = new TaotuDetailimpl();
					TaotuDetail taotudetails = taotuDetail.getImgsBox(urlsp,10);
					String[] aps = taotudetails.getUrlsp();
					resulturls = StringUtil.concat(resulturls, aps);
				}
				taotudetail.setUrls(resulturls);
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MeiTuLu.getUrl()){
				taotudetail.setContent("��ͼ¼����"+contentElements2.text()+contentElements.text()+"��");
				String prevSelector = contexts.get("taotu-detail-prev-selector");
				Elements prevElements = doc.select(prevSelector);
				String[] resulturls = {};
				String urlsp = "";
				if(prevElements.isEmpty()){
					taotudetail.setPrevPage(StringUtil.Base64encode(""));
					taotudetail.setNextPage(StringUtil.Base64encode(""));
					urlsp="";
				}else{
				taotudetail.setPrevPage(StringUtil.Base64encode(prevElements.get(0).absUrl("href")));
				taotudetail.setNextPage(StringUtil.Base64encode(prevElements.get(1).absUrl("href")));
				urlsp=prevElements.get(1).absUrl("href");
				}
				resulturls = new String[imgsElements.size()];
				System.out.println("���ڻ�ȡ��վ����"+url+"����ͼƬ���ϣ����ƣ���"+imgsElements.size()+"����ͼƬ����");
				for(Element els : imgsElements){
					resulturls[a] = els.absUrl("src");
					a++;
				}
				if(urlsp == null || urlsp == "" || urlsp.equals(url)){
					
				}else{
					
					TaotuDetailimpl taotuDetail = new TaotuDetailimpl();
					TaotuDetail taotudetails = taotuDetail.getImgsBox(urlsp,10);
					String[] aps = taotudetails.getUrlsp();
					resulturls = StringUtil.concat(resulturls, aps);
				}
				taotudetail.setUrls(resulturls);
			}else if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.RouSi365.getUrl()){
				taotudetail.setContent("Rousimm����"+contentElements.text()+"��");
				String[] resulturls = new String[imgsElements.size()/2];
				System.out.println("���ڻ�ȡ��վ����"+url+"����ͼƬ���ϣ����ƣ���"+imgsElements.size()/2+"����ͼƬ����");
				for(Element els : imgsElements){
					if(a<imgsElements.size()/2){
						resulturls[a] = els.absUrl("href").replace("www.rosi365.com","rosi.8007077168.com/rosi365").replace("thumbs/thumbs_", "");
					}else{
						break;
					}
					a++;
				}
				taotudetail.setUrls(resulturls);
			}else{
				taotudetail.setContent("��Ŷ���Բ�����վ����"+url+"����վ����ϢĿǰ��δ֧�ֲɼ�����");
			}
			return taotudetail;
		} catch (Exception e) {
				System.err.println(url + ",�����ˡ�" +(is+1)+"/" +maxTryTimes + "������Ȼ��ȡʧ���ˣ�");
				System.out.println(e);
			}
		}
		throw new RuntimeException(url + ",������" + maxTryTimes + "����Ȼ��ȡʧ���ˣ�");
	}
	/**
	 * ͨ��url��ȡ��ҳ������ַ
	 * @param url
	 */
	public TaotuDetail getImgsBox(String url,int ctime){
		TaotuDetail taotudetail = new TaotuDetail();
		if(TaotuSiteEnum.getEnumUrl(url)==TaotuSiteEnum.MeiNvTuPianNvShend.getUrl()){
			String result;
			try {
				result = super.crawl(url);
				Document doc = Jsoup.parse(result);
				doc.setBaseUri(url);
				Map<String,String> contexts=NovelSpiderUtil.getContext(TaotuSiteEnum.getEnumByUrl(url));
				String imgsBoxSelector = contexts.get("taotu-detail-imgsbox-selector");
				Elements imgsBoxElements = doc.select(imgsBoxSelector);
				//�����޸ģ�������Ҫ�ϲ��������е�����
				for(Element imgBox : imgsBoxElements){
					String boxUrl = imgBox.absUrl("href");
					taotudetail = getsTaotuDetail(boxUrl,ctime);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}else{
			taotudetail = getsTaotuDetail(url,ctime);
		}
		
		return taotudetail;
	}
	
}
