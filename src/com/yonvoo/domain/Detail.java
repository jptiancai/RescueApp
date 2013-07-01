package com.yonvoo.domain;

/**
 * 
 * @功能 数据库表中的实体类
 * 
 * @创建日志 Young Jul 1
 * 
 * @修改日志 暂无
 * 
 * @如何使用 通过public的 getter/setter 来进行操作
 * 
 * @注意的地方
 * 
 * @开发日志 TODO
 * 
 */

public class Detail
{

	private int id;
	private String content;

	public Detail(int id, String content)
	{
		this.id = id;
		this.content = content;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getId()
	{
		return id;
	}

}
