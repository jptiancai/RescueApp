package com.yonvoo.service;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yonvoo.domain.Detail;

public class DetailService {

	private DBHelper dbhelper = new DBHelper();
	
	public List<Detail> find(){
		List<Detail> details=new ArrayList<Detail>();
		SQLiteDatabase db=dbhelper.openDatabase();
		Cursor cursor=db.rawQuery("select * from T_Detail", null);
		while (cursor.moveToNext()) {
			int id=cursor.getColumnIndex("_id");
			String content=cursor.getString(cursor.getColumnIndex("content"));
			details.add(new Detail(id, content));
		}
		cursor.close();
		dbhelper.closeDatabase();
		return details;
	}
}
