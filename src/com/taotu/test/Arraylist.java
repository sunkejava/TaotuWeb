package com.taotu.test;

import java.util.ArrayList;

import com.taotu.entity.Taotu;

public class Arraylist {
	public static void main(String[] args) {
		ArrayList<Taotu> list = new ArrayList<Taotu>();
		for(int i=0;i<10;i++){
			Taotu taotu = new Taotu();
			taotu.setAddTime("2017-05-30---"+i);
			taotu.setCrawlTime("2017-05-30 13:07:08---"+i);
			taotu.setImgUrl("https://www.meitulu.com/item/3036.html, imgUrl=http://mtl.woatb.com/uploadfile/2015/0718/thumb_220_300_20150718030954477.jpg---"+i);
			taotu.setTagsName("��ǩ��ѧ���� ����Ů �̷� �Ʒ� ��Ů---"+i);
			taotu.setTitle("[DGC] NO.1087 �������/��Ȥޤ� Mayu Kamiya д����ͼ---"+i);
			taotu.setTypeName("Beaurt---"+i);
			taotu.setUrl("thumb_220_300_20150718030954477.jpg---"+i);
			list.add(taotu);
		}
		for(Taotu sa : list){
			System.out.println(sa.getTagsName());
		}
		
	}
	
}
