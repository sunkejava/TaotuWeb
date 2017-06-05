package com.taotu.starts;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.taotu.impl.GetAllImgboxsModel;
import com.taotu.impl.GetAllImgsDetailToDb;
import com.taotu.util.DbUtil;

public class Starts {
	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
        	System.out.println("执行开始当前时间"+formatter.format(Calendar.getInstance().getTime()));
        	GetAllImgboxsModel a = new GetAllImgboxsModel();
			GetAllImgsDetailToDb b = new GetAllImgsDetailToDb();
			a.getAllBoxsMod();
			DbUtil.deleteDistinct();
			String times = b.insertImgstoDb();
			System.out.println(times);
			System.out.println("执行完毕当前时间"+formatter.format(Calendar.getInstance().getTime()));
        } catch (Exception e) {
            System.out.println("-------------解析信息发生异常--------------"+e);
        }
	}
}
