package com.taotu.enums;

/**
 * 已经被支持的网站枚举
 * @author Administrator
 *
 */
public enum TaotuSiteEnum {
	BeautylegMM(1,"beautylegmm.com"),
	MeiNvTuPian(2,"zngirls.com/gallery/"),
	MeiTuLu(3,"meitulu.com"),
	MM2(4,"33mn.net"),
	RouSi365(5,"rosi365.com"),
	DiSi8(6,"disi8.com"),
	MeiNvTuPianNvShen(7,"zngirls.com/tag/"),
	MeiNvTuPianNvShend(8,"zngirls.com/girl/"),
	MeiNvTuPianNvShenp(9,"zngirls.com/g/"),;
	private int id;
	private String url;
	private TaotuSiteEnum(int id,String url){
		this.id = id;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public static TaotuSiteEnum getEnumById(int id){
		switch(id){
		case 1: return BeautylegMM;
		case 2: return MeiNvTuPian;
		case 3: return MeiTuLu;
		case 4: return MM2;
		case 5: return RouSi365;
		case 6: return DiSi8;
		case 7: return MeiNvTuPianNvShen;
		case 8: return MeiNvTuPianNvShend;
		case 9: return MeiNvTuPianNvShenp;
		default: throw new RuntimeException("没有ID为"+id+"的网站！！");
		}
	}
	public static TaotuSiteEnum getEnumByUrl(String url){
		for(TaotuSiteEnum taotuSiteEnum: values()){
			if(url.contains(taotuSiteEnum.url)){
				return taotuSiteEnum;
			}
		}
		throw new RuntimeException("url为"+url+"的网站尚未支持！！！");
	}
	
	public static String getEnumUrl(String url){
		String result = "";
		if(url.contains(BeautylegMM.getUrl())){
			result = BeautylegMM.getUrl();
		}else if(url.contains(MeiNvTuPian.getUrl())){
			result = MeiNvTuPian.getUrl();
		}else if(url.contains(MeiTuLu.getUrl())){
			result = MeiTuLu.getUrl();
		}else if(url.contains(MM2.getUrl())){
			result = MM2.getUrl();
		}else if(url.contains(RouSi365.getUrl())){
			result = RouSi365.getUrl();
		}else if(url.contains(DiSi8.getUrl())){
			result = DiSi8.getUrl();
		}else if(url.contains(MeiNvTuPianNvShen.getUrl())){
			result = MeiNvTuPianNvShen.getUrl();
		}else if(url.contains(MeiNvTuPianNvShend.getUrl())){
			result = MeiNvTuPianNvShend.getUrl();
		}else if(url.contains(MeiNvTuPianNvShenp.getUrl())){
			result = MeiNvTuPianNvShenp.getUrl();
		}else{
			result = "网站：【"+url+"】尚未支持解析！！";
		}
		return result;
	}
}
