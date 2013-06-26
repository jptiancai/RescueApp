package com.yonvoo.test;

import java.util.List;

import com.yonvoo.domain.Category;
import com.yonvoo.service.CategoryService;

import android.test.AndroidTestCase;

public class DBTest extends AndroidTestCase {
	
	private void testFind(){
		CategoryService cs=new CategoryService();
		List<Category> categorys = cs.findCategoryName();

			System.out.println(categorys.get(0).getCategoryName());
		
	}

}
