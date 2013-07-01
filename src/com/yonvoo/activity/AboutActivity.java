package com.yonvoo.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.yonvoo.main.R;

/**
 * @功能 显示关于界面
 * 
 * @创建日志 姜工 2013-7-1
 * 
 * @修改日志 暂无
 * 
 * @如何使用 在主界面MainActivity，开启Intent时调用
 * 
 * @注意的地方 暂无
 * 
 * @开发日志 TODO 后期需要增加企业微信平台
 * TODO 点击关于按钮的时候，屏幕出现了短期的黑屏
 * 
 */
public class AboutActivity extends Activity {

	//private TextView mWeixin; 微信申请中
	private TextView mWeibo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		setTitle("关于");
		//微博
		//http://e.weibo.com/yonvoo?ref=http%3A%2F%2Fweibo.com%2Fu%2F2150547963
		String htmlLinkTextWeibo = "<a href=\"#\"> "+getResources().getString(R.string.about_sina)+"</a>";
		mWeibo = (TextView) findViewById(R.id.about_textview_weibo);
		//设置以超链接的 格式显示文字
		mWeibo.setText(Html.fromHtml(htmlLinkTextWeibo));
		mWeibo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("android.intent.action.VIEW");
				Uri content_url = Uri
						.parse("http://e.weibo.com/yonvoo?ref=http%3A%2F%2Fweibo.com%2Fu%2F2150547963");
				intent.setData(content_url);
				startActivity(intent);
			}
		});
	}
}
