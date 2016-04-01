package com.subject.liuxia.activity;

import com.subject.liuxia.utils.ActivitiesManager;
import com.subject.liuxia.utils.LogUtils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * 
 * @author YY
 *
 */
@SuppressLint("NewApi")
public class BaseFragmengActivity extends FragmentActivity {
	

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		ActivitiesManager.getInstance().pushActivity(this);
		LogUtils.i("当前Activity:", this.getClass().getSimpleName());
	}
	
	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivitiesManager.getInstance().popActivity(this);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}
}
