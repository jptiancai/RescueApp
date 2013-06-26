package com.yonvoo.service;


import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

public class DBHelper {
	
	private SQLiteDatabase db;
	public static final String PACKAGE_NAME = "com.yonvoo.main";
    public static final String DB_PATH = "/data"
            + Environment.getDataDirectory().getAbsolutePath() + "/"
            + PACKAGE_NAME+"/Rescue.db"; 
    
    public SQLiteDatabase openDatabase(){
    	db = SQLiteDatabase.openDatabase(DB_PATH, null, 0);
    	
    	return db;
    }
    
    public void closeDatabase(){
    	db.close();
    }
}
