package com.zjz.baseactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentLayout(R.layout.activity_main);
		setTitle("µÇÂ¼");
		setTv_right_String("×¢²á");
		//hideTitleView();
		hidebtn_left();
		//setContentView(R.layout.activity_main);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		super.onClick(v);
		
		switch (v.getId()) {
		case R.id.btn_right:
			Log.d("tag", "µã»÷ÁË°´Å¥");
			Intent  intent=new Intent(MainActivity.this,SecondActivity.class);
			startActivity(intent);
			break;
				
		case R.id.text_title:
		default:
			break;
		}
		
		
	}

	
	
	
}
