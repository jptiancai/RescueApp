package com.yonvoo.service;

import java.util.ArrayList;
import java.util.List;

import com.yonvoo.domain.SecCategory;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

public class SecCategoryService
{

	private DBHelper dbhelper = new DBHelper();

	public List<SecCategory> find()
	{
		List<SecCategory> seccategorys = new ArrayList<SecCategory>();
		SQLiteDatabase db = dbhelper.openDatabase();
		Cursor cursor = db.rawQuery("select * from T_SecCategory ", null);
		while (cursor.moveToNext())
		{
			int id = cursor.getColumnIndex("_id");
			String title = cursor.getString(cursor.getColumnIndex("title"));
			String categoryName = cursor.getString(cursor
					.getColumnIndex("category_id"));
			seccategorys.add(new SecCategory(id, title, categoryName));
		}
		cursor.close();
		dbhelper.closeDatabase();
		return seccategorys;
	}

	public List<String> findTitle(int category_Id)
	{
		List<String> titles = new ArrayList<String>();
		SQLiteDatabase db = dbhelper.openDatabase();
		Cursor cursor = db.rawQuery(
				"select title from T_SecCategory where category_id=?",
				new String[]
				{ category_Id + "" });
		while (cursor.moveToNext())
		{
			String title = cursor.getString(cursor.getColumnIndex("title"));
			titles.add(title);
		}
		cursor.close();
		dbhelper.closeDatabase();
		return titles;
	}

	public String findId(String title)
	{
		String id = "";

		SQLiteDatabase db = dbhelper.openDatabase();
		Cursor cursor = db.rawQuery(
				"select _id from T_SecCategory where title=?", new String[]
				{ title });
		while (cursor.moveToNext())
		{
			id = cursor.getString(cursor.getColumnIndex("_id"));

		}
		cursor.close();
		dbhelper.closeDatabase();
		return id;
	}

}
