package com.yonvoo.domain;

public class Detail {
	
	private int id;
	private String content;
	
//	public Detail() {}
	
	
	public Detail(int id,String content) {
		this.id=id;
		this.content=content;
	}
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	

}
