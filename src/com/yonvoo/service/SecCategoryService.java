package com.yonvoo.service;

import java.util.ArrayList;
import java.util.List;

import com.yonvoo.domain.SecCategory;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SecCategoryService {

	private DBHelper dbhelper = new DBHelper();

	public List<SecCategory> find() {
		List<SecCategory> seccategorys = new ArrayList<SecCategory>();
		SQLiteDatabase db = dbhelper.openDatabase();
		Cursor cursor = db.rawQuery("select * from ", null);
		while (cursor.moveToNext()) {
			int id = cursor.getColumnIndex("_id");
			String title = cursor.getString(cursor.getColumnIndex("title"));
			String categoryName = cursor.getString(cursor
					.getColumnIndex("categoryName"));
			seccategorys.add(new SecCategory(id, title, categoryName));
		}
		cursor.close();
		dbhelper.closeDatabase();
		return seccategorys;
	}
	
}
