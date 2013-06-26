package com.yonvoo.domain;

public class SecCategory {
	
	private int id;
	private String title;
	private String categoryName;
	
	
	public SecCategory() {
	}
	
	public SecCategory(int id,String title,String categoryName) {
		this.id=id;
		this.title=title;
		this.categoryName=categoryName;
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
