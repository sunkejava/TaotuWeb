package com.taotu.starts;

import java.text.ParseException;
import java.util.TimerTask;

import com.taotu.impl.GetAllImgboxsModel;
import com.taotu.impl.GetAllImgsDetailToDb;
import com.taotu.util.DbUtil;

/** 
 * 执行内容 
 * @author Decline 
 * 
 */  
public class Task extends TimerTask {  
    public void run() {  
    	System.out.println("开始自动执行任务！！");
    	GetAllImgboxsModel a = new GetAllImgboxsModel();
		GetAllImgsDetailToDb b = new GetAllImgsDetailToDb();
		try {
			a.getAllBoxsMod();
			DbUtil.deleteDistinct();
			String times = b.insertImgstoDb();
			System.out.println(times);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }  
}  