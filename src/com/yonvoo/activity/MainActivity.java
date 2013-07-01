package com.yonvoo.activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
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
/**
 * 
 * @功能 显示一级分类，后续应该还会增加 
 * 
 * @创建日志 姜布斯 2013-7-1下午5:44:56
 * 
 * @修改日志 无
 * 
 * @如何使用 
 * 
 * @注意的地方 actionbar的版本问题，android系统需要3.0+ 
 * 
 * @开发日志 TODO 修改gridview项目点击时背景所显示问题
 *
 */
public class MainActivity extends Activity {

	private GridView gridView;
	private ScaleAnimation sa;
	private LayoutAnimationController lac;
	// 定义一个变量，来标识是否退出
	private static boolean isExit = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//栏目名称
		String[] titles = { "自然灾害", "运动自救", "日常意外" };
		int[] resIds = { R.drawable.ziranzaihai, R.drawable.yundongzijiu,
				R.drawable.richangyiwai };
		gridView = (GridView) this.findViewById(R.id.gridview);
		gridView.setAdapter(new GridViewAdapter(this, titles, resIds));
		// 动画的方向
		sa = new ScaleAnimation(0, 1, 0, 1);
		// 动画的时间
		sa.setDuration(900);
		//设置动画
		lac = new LayoutAnimationController(sa);
		lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
		gridView.setLayoutAnimation(lac);
		gridView.startLayoutAnimation();
		gridView.setOnItemClickListener(new OnListItemClickListener());
		
		dbInsert();
	}
	
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			 exit();
	            return false;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	/**
	 * 退出系统
	 */
	 private void exit() {
	        if (!isExit) {
	            isExit = true;
	            Toast.makeText(getApplicationContext(), "再按一次退出程序",
	                    Toast.LENGTH_SHORT).show();
	            // 利用handler延迟发送更改状态信息
	            mHandler.sendEmptyMessageDelayed(0, 2000);
	        } else {
	            finish();
	            System.exit(0);
	        }
	    }
	
	/**
	 * 从assets文件夹读取，写入到应用安装路径下
	 */
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
	 * gridview监听事件，注意和罗工传值要一致
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
			//设置Activity切换动画，由右向左切换
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_main, menu);
		//设置关于按钮
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
