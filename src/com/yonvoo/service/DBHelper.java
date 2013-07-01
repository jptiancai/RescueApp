package com.yonvoo.service;

import android.database.sqlite.SQLiteDatabase;
/**
 * 
 * @功能 数据库工具类 
 * 
 * @创建日志 姜布斯 2013-7-1下午5:55:22
 * 
 * @修改日志 从手机SDcard卡读取改为从databases数据库读取
 * 
 * @如何使用 new使用 
 * 
 * @注意的地方 路径path容易写错
 * 
 * @开发日志 TODO 写到value的String文件中
 *
 */
public class DBHelper {

	private SQLiteDatabase db;
	String path;

	/**
	 * 打开数据库
	 * @return	数据库对象
	 */
	public SQLiteDatabase openDatabase() {
		path = "/data/data/com.yonvoo.main/databases/Rescue.db";
		db = SQLiteDatabase.openDatabase(path, null, 0);
		return db;
	}

	/**
	 * 关闭数据库
	 */
	public void closeDatabase() {
		db.close();
	}
}
