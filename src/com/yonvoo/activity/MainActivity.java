package com.yonvoo.activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

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

		// GridView
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

		dbInsert();

	}

	private void dbInsert() {
		String DB_PATH = "/data/data/com.yonvoo.main/databases/";
		String DB_NAME = "Rescue.db";

		// 检查 SQLite 数据库文件是否存在
		if ((new File(DB_PATH + DB_NAME)).exists() == false) {
			// 如 SQLite 数据库文件不存在，再检查一下 database 目录是否存在
			File f = new File(DB_PATH);
			// 如 database 目录不存在，新建该目录
			if (!f.exists()) {
				f.mkdir();
			}

			try {
				// 得到 assets 目录下我们实现准备好的 SQLite 数据库作为输入流
				InputStream is = getBaseContext().getAssets().open(DB_NAME);
				// 输出流
				OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);

				// 文件写入
				byte[] buffer = new byte[1024];
				int length;
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}

				// 关闭文件流
				os.flush();
				os.close();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * gridview监听事件
	 * 
	 * @author 姜工
	 * 
	 */
	private final class OnListItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent intent = new Intent(MainActivity.this,
					SecCategoryActivity.class);
			switch (position) {
			case 0:
				intent.putExtra("natureId", 1);
				break;
			case 1:
				intent.putExtra("sportId", 2);
				break;
			case 2:
				intent.putExtra("dayId", 3);
				break;

			}
			startActivity(intent);
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_main, menu);
		menu.findItem(R.id.subitem2).getActionView();
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.subitem2:
			Intent intent = new Intent(MainActivity.this, AboutActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
