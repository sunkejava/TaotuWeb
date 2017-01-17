package com.taotu.impl;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.taotu.entity.Taotu;
import com.taotu.util.DbUtil;
import com.taotu.util.FileUtil;
import com.taotu.util.StringUtil;

public class GetAllImgboxsModel {
	
	public boolean getAllBoxsMod() throws ParseException{
		boolean flag = false;
		GetAllUrls gets = new GetAllUrls();
		String sps=DbUtil.getresult();
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginTime = dfs.parse(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
		String siteurls = "";
//		String siteurlsa="";
//		try {
//		siteurlsa = FileUtil.readTxtFile(new File("c:/siteurls.txt"));
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		try {
			
			siteurls = gets.getWebsiteUrls();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		FileUtil.contentToTxt("C:/siteurls.txt", siteurls);
		String[] urls = siteurls.split(",");
		System.err.println("开始获取图片地址：");
		for(int i=0;i<urls.length;i++){
			Taotuimpl beli = new Taotuimpl();
			Taotu[] taotu = beli.getsTaotuList(urls[i].replace("null", "").replace(" ", ""),20);
			
			for(Taotu tsa : taotu){
				if(sps.contains(StringUtil.Base64encode(tsa.getUrl()))){
					//System.out.println("已存在结果集："+tsa.toString());
					
				}else{
					System.out.println("开始插入："+tsa.toString());
					flag = DbUtil.insertTaotu(tsa);
					
				}
				
			}
		}
		Date endTime = dfs.parse(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
		long between=(endTime.getTime()-beginTime.getTime())/1000;//除以1000是为了转换成秒   
		long day1=between/(24*3600);   
		long hour1=between%(24*3600)/3600;   
		long minute1=between%3600/60;   
		long second1=between%60/60;   
		System.err.println("本次采集共计耗时："+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒");
		return flag;
	}
}
