package com.yonvoo.service;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yonvoo.domain.Detail;

public class DetailService
{

	private DBHelper dbhelper = new DBHelper();

	public List<String> findContent(int _id)
	{
		List<String> titles = new ArrayList<String>();
		SQLiteDatabase db = dbhelper.openDatabase();
		Cursor cursor = db.rawQuery(
				"select content from T_Detail where fk_id=?", new String[]
				{ _id + "" });
		while (cursor.moveToNext())
		{
			String title = cursor.getString(cursor.getColumnIndex("content"));
			titles.add(title);
		}
		cursor.close();
		dbhelper.closeDatabase();
		return titles;
	}
}
