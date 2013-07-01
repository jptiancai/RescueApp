package com.yonvoo.service;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yonvoo.domain.Detail;

/**
 * 
 * @功能 DetailActivity的DAO(Database access object)，具体实现对于数据库中表的查询操作
 * 
 * @创建日志 Luo & Young Jul 1
 * 
 * @修改日志 暂无
 * 
 * @如何使用 在显示activity的时候，进行实例化操作，调用DAO中的方法
 * 
 * @注意的地方 由于在数据库表中，主键和外键的关系已经确定
 * 
 * @开发日志 TODO
 * 
 */

public class DetailService
{

	private DBHelper dbhelper = new DBHelper();

	/**
	 * 从数据库中将详细信息的内容查出来
	 * @param _id 数据库表的主键
	 * @return 查到的内容(泛型)List
	 */
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
