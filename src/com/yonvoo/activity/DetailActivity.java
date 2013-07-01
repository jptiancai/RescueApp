package com.yonvoo.activity;

import java.util.*;

import com.yonvoo.main.R;
import com.yonvoo.service.DetailService;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends Activity
{
	TextView tx01;
	int id_result;

	/**
	 * 显示详细信息activity,设置activity布局，将TextView上的数据相似出来
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
	 * 查询Sqlite的数据信息
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
