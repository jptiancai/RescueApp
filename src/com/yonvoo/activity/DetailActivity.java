package com.yonvoo.activity;

import java.util.*;

import com.yonvoo.main.R;
import com.yonvoo.service.DetailService;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * 
 * @功能 在详细activity上显示从数据库里查询出的内容
 * 
 * @创建日志 Young Jul 1
 * 
 * @修改日志 暂无
 * 
 * @如何使用 从SecCategoryActivity上跳转到DetailActivity上去
 * 
 * @注意的地方 Intent跳转
 * 
 * @开发日志 TODO
 * 
 */

public class DetailActivity extends Activity
{
	TextView tx01;
	int id_result;

	/**
	 * 设置该activity的布局，将TextView上的数据显示出来
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		tx01 = (TextView) findViewById(R.id.tx01);
		queryInfo();
	}

	/**
	 * 根据第三张表的主键、外键约束条件，将查询到Sqlite的数据信息设定在TextView上
	 */
	public void queryInfo()
	{
		String id_X = getIntent().getExtras().getString("id");
		Log.i("Detail", id_X);
		id_result = Integer.parseInt(id_X);
		DetailService ds = new DetailService();
		List<String> list = ds.findContent(id_result);
		String content = list.get(0);
		tx01.setText(content);
	}
}
