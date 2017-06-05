package com.taotu.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.taotu.entity.TaotuDetail;
import com.taotu.util.DbUtil;
import com.taotu.util.StringUtil;

public class GetAllImgsDetailToDb {
	
	public static String insertImgstoDb() throws ParseException{
		String s = DbUtil.getAll();
		String[] sps = s.split(",");
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginTime = dfs.parse(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
		for(int i=0;i<sps.length;i++){
			String[] spsa = sps[i].split("----");
			String aurl = new String(StringUtil.Base64decode(spsa[0]));
			System.out.println("正在采集第【"+(i+1)+"/"+sps.length+"】地址的图片集合："+aurl);
			TaotuDetailimpl taotuDetail = new TaotuDetailimpl();
			TaotuDetail taotudetail = taotuDetail.getImgsBox(aurl,50);
			DbUtil.insertTaotuDetail(taotudetail.getUrlsp(),taotudetail.getContent(),spsa[0],Integer.parseInt(spsa[1]));
		}
		Date endTime = dfs.parse(StringUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
		long between=(endTime.getTime()-beginTime.getTime())/1000;//除以1000是为了转换成秒   
		long day1=between/(24*3600);   
		long hour1=between%(24*3600)/3600;   
		long minute1=between%3600/60;   
		long second1=between%60/60;   
		System.err.println("本次采集共计耗时："+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒");
		String res = "本次采集共计耗时："+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒";
		return res;
	}
	
}
