package com.yonvoo.activity;

import java.util.ArrayList;
import java.util.List;

import com.yonvoo.adapter.ListViewAdapter;
import com.yonvoo.domain.SecCategory;
import com.yonvoo.main.R;
import com.yonvoo.service.DBHelper;
import com.yonvoo.service.SecCategoryService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class SecCategoryActivity extends Activity {

	ListView lv;

	int[] dayImgs = new int[] { R.drawable.day1, R.drawable.day2,
			R.drawable.day3 };
	int[] sportImgs = new int[] { R.drawable.sport2, R.drawable.sport3,
			R.drawable.sport1 };
	int[] natureImgs = new int[] { R.drawable.nature1, R.drawable.nature2,
			R.drawable.nature3, R.drawable.nature4, R.drawable.nature5,
			R.drawable.nature6, R.drawable.nature7, R.drawable.nature8 };

	SecCategoryService sec_Category_Service;
	List<String> lists = new ArrayList<String>();

	private ScaleAnimation sa;
	private LayoutAnimationController lac;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sec_category);

		lv = (ListView) findViewById(R.id.secList);

		lv.setOnItemClickListener(new ListViewItemClick());
		sec_Category_Service = new SecCategoryService();

		int natureId = getIntent().getExtras().getInt("natureId");
		int sportId = getIntent().getExtras().getInt("sportId");
		int dayId = getIntent().getExtras().getInt("dayId");

		if (natureId == 1) {
			showNatureList(1);
		}

		if (sportId == 2) {
			showSportList(2);
		}

		if (dayId == 3) {
			showDay(3);
		}
	}

	private final class ListViewItemClick implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			TextView title = (TextView) view.findViewById(R.id.listItemTitle);
			Intent intent = new Intent(SecCategoryActivity.this,
					DetailActivity.class);
			String id1 = sec_Category_Service.findId((String) title.getText());
			intent.putExtra("id", id1);
			startActivity(intent);

			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		}

	}

	private void showDay(int dayId) {
		lists = sec_Category_Service.findTitle(dayId);
		lv.setAdapter(new ListViewAdapter(this, lists, natureImgs));
		lv.setLayoutAnimation(getListAnim());

	}

	private void showSportList(int sportId) {
		lists = sec_Category_Service.findTitle(sportId);
		lv.setAdapter(new ListViewAdapter(this, lists, sportImgs));
		lv.setLayoutAnimation(getListAnim());

	}

	private void showNatureList(int natureId) {
		lists = sec_Category_Service.findTitle(natureId);
		lv.setAdapter(new ListViewAdapter(this, lists, dayImgs));
		lv.setLayoutAnimation(getListAnim());
	}

	private LayoutAnimationController getListAnim() {
		AnimationSet set = new AnimationSet(true);
		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(300);
		set.addAnimation(animation);

		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				-1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(300);
		set.addAnimation(animation);
		LayoutAnimationController controller = new LayoutAnimationController(
				set, 0.5f);
		return controller;
	}
}
