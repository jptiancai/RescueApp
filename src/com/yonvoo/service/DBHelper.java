package com.yonvoo.service;

import java.io.File;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

public class DBHelper {

	private SQLiteDatabase db;
	/*
	 * public static final String PACKAGE_NAME = "com.yonvoo.main"; public
	 * static final String DB_PATH = "/data" +
	 * Environment.getDataDirectory().getAbsolutePath() + "/" + PACKAGE_NAME +
	 * "/Rescue.db";
	 */
	String path;

	public SQLiteDatabase openDatabase() {
		/*File audio = new File(Environment.getExternalStorageDirectory(),
				"/Rescue.db");
		if (audio.exists()) {
			path = audio.getAbsolutePath();
			db = SQLiteDatabase.openDatabase(path, null, 0);
		}*/
		path = "/data/data/com.yonvoo.main/databases/Rescue.db";
		db = SQLiteDatabase.openDatabase(path, null, 0);
		return db;
	}

	public void closeDatabase() {
		db.close();
	}
}
