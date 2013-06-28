package com.yonvoo.adapter;

import java.util.List;

import com.yonvoo.domain.SecCategory;
import com.yonvoo.main.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	List<String> titles;
	int[] imgs;
	LayoutInflater inflater;

	public ListViewAdapter(Context context, List<String> titles, int[] imgs) {
		this.titles = titles;
		this.imgs = imgs;
		inflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {

		return titles.size();
	}

	@Override
	public Object getItem(int position) {

		return titles.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		if (convertView==null) {
			View view=inflater.inflate(R.layout.listview_item, null);
			ImageView img=(ImageView) view.findViewById(R.id.listItemImage);
			TextView title=(TextView) view.findViewById(R.id.listItemTitle);
			title.setText(titles.get(position));
			img.setImageResource(imgs[position]);
			return view;
			
		}else {
			ImageView img=(ImageView) convertView.findViewById(R.id.listItemImage);
			TextView title=(TextView) convertView.findViewById(R.id.listItemTitle);
			title.setText(titles.get(position));
			img.setImageResource(imgs[position]);
			return convertView;
		}

	}

}
