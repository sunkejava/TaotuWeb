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
        	System.out.println("ִ�п�ʼ��ǰʱ��"+formatter.format(Calendar.getInstance().getTime()));
        	String startTime= formatter.format(Calendar.getInstance().getTime());
        	GetAllImgboxsModel a = new GetAllImgboxsModel();
			GetAllImgsDetailToDb b = new GetAllImgsDetailToDb();
			a.getAllBoxsMod();
			DbUtil.deleteDistinct();
			String times = b.insertImgstoDb();
			System.out.println(times);
			System.out.println("ִ�п�ʼʱ�䣺"+startTime);
			System.out.println("ִ����ϵ�ǰʱ��: "+formatter.format(Calendar.getInstance().getTime()));
			
        } catch (Exception e) {
            System.out.println("-------------������Ϣ�����쳣--------------");
        }
    }
}
