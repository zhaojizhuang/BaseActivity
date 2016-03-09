package com.zjz.baseactivity;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 继承于Activity用于以后方便管理
 * 
 * @author zhaojizhuang
 * 
 */
public class BaseActivity extends Activity implements OnClickListener{
	//用于保存打开的所有的activity
	public static LinkedList<Activity> allActivitys = new LinkedList<Activity>();  
	
	private static final String TAG = "BaseActivity";
	//标题view
	private View titleView;
	//标题文字
	private TextView tv_title;
	//标题右边的文字 按钮
	private TextView tv_right;
	//返回按钮
	private ImageView returButton;
	//加载内容的框架
	private LinearLayout ly_content;
	// 内容区域的布局
	private View contentView;
	//标题下面的下滑线
	private View title_bottom_line;

	/**
	 * 用的一个开源框架，项目地址在 https://github.com/zhaojizhuang/zprogresshud
	 * 
	 * 
	 * 
	 * 
	 * 用的时候比较简单   progressHUD.show() 和progressHUD.dismiss()
	 */
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 取消标题栏
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		 allActivitys.add(this); 
		setContentView(R.layout.common_title);
		titleView = findViewById(R.id.titleView);
		tv_title = (TextView) titleView.findViewById(R.id.text_title);
		
		tv_right = (TextView) titleView.findViewById(R.id.btn_right);
		returButton=(ImageView) findViewById(R.id.return_left);
		title_bottom_line=findViewById(R.id.title_bottom_line);
		
		tv_title.setOnClickListener(this);
		tv_right.setOnClickListener(this);
		returButton.setOnClickListener(this);
		

		ly_content = (LinearLayout) findViewById(R.id.ly_content);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.return_left:
			Log.d(TAG, TAG+"点击了左侧按钮");
			//退出
			finish();
			break;
		case R.id.btn_right:
			Log.d(TAG,  TAG+"点击了右侧按钮");
			break;
		case R.id.text_title:
			Log.d(TAG,  TAG+"点击了标题");
			break;
		default:
			break;
		}
		
		
		
	}

	/***
	 * 设置内容区域
	 * 
	 * @param resId
	 *            资源文件ID
	 */
	@SuppressWarnings("deprecation")
	public void setContentLayout(int resId) {

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		contentView = inflater.inflate(resId, null);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		contentView.setLayoutParams(layoutParams);
		contentView.setBackgroundDrawable(null);
		if (null != ly_content) {
			ly_content.addView(contentView);
		}

	}

	/***
	 * 设置内容区域
	 * 
	 * @param view
	 *            View对象
	 */
	public void setContentLayout(View view) {
		if (null != ly_content) {
			ly_content.addView(view);
		}
	}

	/**
	 * 得到内容的View
	 * 
	 * @return
	 */
	public View getLyContentView() {

		return contentView;
	}

	/**
	 * 得到左边的按钮
	 * 
	 * @return
	 */
	public View getbtn_left() {
		return returButton;
	}



	/**
	 * 设置标题
	 * 
	 * @param title
	 */
	public void setTitle(String title) {

		if (null != tv_title) {
			tv_title.setText(title);
		}

	}

	/**
	 * 设置标题
	 * 
	 * @param resId
	 */
	public void setTitle(int resId) {
		tv_title.setText(getString(resId));
	}

	/**
	 * 设置左边按钮的图片资源
	 * 
	 * @param resId
	 */
	public void setbtn_leftRes(int resId) {
		if (null != returButton) {
			returButton.setImageResource(resId);
		}

	}

	/**
	 * 设置左边按钮的图片资源
	 * 
	 * @param bm
	 */
	public void setbtn_leftRes(Drawable drawable) {
		if (null != returButton) {
			returButton.setImageDrawable(drawable);
		}

	}

	/**
	 * 设置右边按
	 * 
	 * @param resId
	 */
	public void setTv_right_String(int resId) {
		if (null != tv_right) {
			tv_right.setText(resId);
		}
	}

	/**
	 * 设置右边
	 * 
	 * @param drawable
	 */
	public void setTv_right_String(String string) {
		if (null != tv_right) {
			tv_right.setText(string);
		}
	}

	/**
	 * 隐藏上方的标题栏
	 */
	public void hideTitleView() {

		if (null != titleView) {
			titleView.setVisibility(View.GONE);
		}
	}

	/**
	 * 隐藏左边的按钮
	 */
	public void hidebtn_left() {

		if (null != returButton) {
			returButton.setVisibility(View.GONE);
		}

	}

	/***
	 * 隐藏右边的按钮
	 */
	public void hidetxt_right() {
		if (null != tv_right) {
			tv_right.setVisibility(View.GONE);
		}

	}

	public View getTitleView() {
		return titleView;
	}

	public TextView getTv_title() {
		return tv_title;
	}

	public TextView getTv_right() {
		return tv_right;
	}

	public ImageView getReturButton() {
		return returButton;
	}

	public View getTitle_bottom_line() {
		return title_bottom_line;
	}
	
	@Override
	 protected void onDestroy() {  
	        super.onDestroy();  
	        allActivitys.remove(this);  
	    }  
	/**
	 * 
	 * 
	 * 退出所有的activity
	 */
	 public static void finishAll(){  
	        for (Activity activity : allActivitys) {  
	            activity.finish();  
	        }  
	        allActivitys.clear();  
	         //这个主要是用来关闭进程的, 光把所有activity finish的话，进程是不会关闭的  
	        System.exit(0);    
//	      android.os.Process.killProcess(android.os.Process.myPid());   
	    }  

}