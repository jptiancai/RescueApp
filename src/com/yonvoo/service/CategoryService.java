package com.yonvoo.service;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yonvoo.domain.Category;

public class CategoryService {

	private DBHelper dbhelper = new DBHelper();

	/**
	 * 
	 * @return
	 */
	public List<Category> findCategoryName() {
		List<Category> lists = new ArrayList<Category>();
		SQLiteDatabase db = dbhelper.openDatabase();
		Cursor cursor = db.rawQuery("select * from T_Category", null);
		while (cursor.moveToNext()) {
			int id = cursor.getInt(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor
					.getColumnIndex("categoryName"));
			lists.add(new Category(id, name));
		}
		cursor.close();
		dbhelper.closeDatabase();
		return lists;
	}

	/**
	 * 
	 * @param category
	 */
	public void insertCategory(Category category) {
		SQLiteDatabase db = dbhelper.openDatabase();
		db.execSQL("insert into T_Category(categoryName)values(?)",
				new Object[] { category.getCategoryName() });
	}

	/**
	 * 
	 * @param category
	 */
	public void updateCategory(Category category) {
		SQLiteDatabase db = dbhelper.openDatabase();
		db.execSQL("update T_Category set categoryName=? where _id=?",
				new Object[] { category.getId() });
	}
	
	/**
	 * 
	 * @param id
	 */
	public void deleteCategory(Integer id){
		SQLiteDatabase db=dbhelper.openDatabase();
		db.execSQL("delete from T_Category where _id=?", new Object[]{id});		
	}
}
