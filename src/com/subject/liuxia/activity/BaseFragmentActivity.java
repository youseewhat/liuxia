package com.subject.liuxia.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

/**
 * 所有activity的基类
 * 
 * @author YY
 */
public class BaseFragmentActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle arg0) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(arg0);
		
		init();
	}

	private void init() {
		setContentLayout();
		findViewById();
		setViewData();
		requestNet();
	}

	
	protected void setContentLayout() {
		
	}

	/**
	 * findViewById
	 */
	protected void findViewById() {
		
	}

	/**
	 * 
	 */
	protected void setViewData() {

	}

	/**
	 * 请求网络
	 */
	protected void requestNet() {
		
	}

	
	
}
