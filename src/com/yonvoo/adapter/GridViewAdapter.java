package com.yonvoo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yonvoo.main.R;

/**
 * 
 * @功能 来显示gridview的适配器
 * 
 * @创建日志 姜布斯 2013-7-1下午5:52:20
 * 
 * @修改日志 无
 * 
 * @如何使用 无
 * 
 * @注意的地方 由于主要参照eoe社区的代码，不太明白他的过程，传神的地方是“利旧”
 * 
 * @开发日志 TODO 加进去传智播客中优化重复findviewbyid造成的问题
 *
 */
public  class GridViewAdapter extends BaseAdapter {

	String[] itemTitles, itemTexts;
	int[] itemImages;
	LayoutInflater inflater;
	
	public GridViewAdapter(Context context,String[] itemTitels, int[] itemImages) {
		this.itemTitles = itemTitels;
		this.itemImages = itemImages;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return this.itemTitles.length;
	}

	@Override
	public Object getItem(int position) {
		return itemTitles[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			View itemView = inflater.inflate(R.layout.griditem, null);
			TextView title = (TextView) itemView
					.findViewById(R.id.ItemTitle);
			title.setText(itemTitles[position]);
			ImageView image = (ImageView) itemView
					.findViewById(R.id.ItemImage);
			image.setImageResource(itemImages[position]);
			return itemView;
		} else {
			TextView title = (TextView) convertView
					.findViewById(R.id.ItemTitle);
			title.setText(itemTitles[position]);
			ImageView image = (ImageView) convertView
					.findViewById(R.id.ItemImage);
			image.setImageResource(itemImages[position]);
			return convertView;
		}
	}

}


