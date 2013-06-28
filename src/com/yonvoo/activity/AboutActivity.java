package com.yonvoo.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.yonvoo.main.R;

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
		mWeibo.setText(Html.fromHtml(htmlLinkTextWeibo));
		mWeibo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
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
