package com.yonvoo.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import com.yonvoo.adapter.GridViewAdapter;
import com.yonvoo.main.R;

public class MainActivity extends Activity {

	private GridView gridView;
	private ScaleAnimation sa;
	private LayoutAnimationController lac;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		/******************** ActionBar ***************************/
		ActionBar actionBar = this.getActionBar();
		// 添加向上箭头
		actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP,
				ActionBar.DISPLAY_HOME_AS_UP);

		/******************** GridView ***************************/
		String[] titles = { "自然灾害", "运动自救", "日常意外" };
		int[] resIds = { R.drawable.ziranzaihai, R.drawable.yundongzijiu,
				R.drawable.richangyiwai };
		gridView = (GridView) this.findViewById(R.id.gridview);
		gridView.setAdapter(new GridViewAdapter(this, titles, resIds));
		// 动画的方向
		sa = new ScaleAnimation(0, 1, 0, 1);
		// 动画的时间
		sa.setDuration(900);

		lac = new LayoutAnimationController(sa);
		lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
		gridView.setLayoutAnimation(lac);
		gridView.startLayoutAnimation();

		gridView.setOnItemClickListener(new OnListItemClickListener());

	}

	private final class OnListItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent intent = new Intent(MainActivity.this,
					SecCategoryActivity.class);
			switch (position) {
			case 0:
				intent.putExtra("natureId", 1);
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
				break;
			case 1:
				intent.putExtra("sportId", 2);
				break;
			case 2:
				intent.putExtra("dayId", 3);
				break;

			}
			startActivity(intent);
			overridePendingTransition(R.anim.push_left_in,
					R.anim.push_left_out);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_main, menu);
		menu.findItem(R.id.optionitem3).getActionView();
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(this, "单击了图标", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.optionitem3:
			Toast.makeText(this, "单击了选项3", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.subitem1:
			Toast.makeText(this, "单击了子菜单选项1", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.subitem2:
			Toast.makeText(this, "单击了子菜单选项2", Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
