package com.taotu.starts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

import com.taotu.impl.GetAllImgboxsModel;
import com.taotu.impl.GetAllImgsDetailToDb;
import com.taotu.util.DbUtil;
public class NFDFlightDataTimerTask extends TimerTask {
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
	public void run() {
        try {
        	System.out.println("执行开始当前时间"+formatter.format(Calendar.getInstance().getTime()));
        	String startTime= formatter.format(Calendar.getInstance().getTime());
        	GetAllImgboxsModel a = new GetAllImgboxsModel();
			GetAllImgsDetailToDb b = new GetAllImgsDetailToDb();
			a.getAllBoxsMod();
			DbUtil.deleteDistinct();
			String times = b.insertImgstoDb();
			System.out.println(times);
			System.out.println("执行开始时间："+startTime);
			System.out.println("执行完毕当前时间: "+formatter.format(Calendar.getInstance().getTime()));
			
        } catch (Exception e) {
            System.out.println("-------------解析信息发生异常--------------");
        }
    }
}
