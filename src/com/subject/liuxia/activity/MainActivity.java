package com.subject.liuxia.activity;

import com.subject.liuxia.R;

import android.os.Bundle;
import android.support.v7.app.ActionBar.DisplayOptions;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends BaseFragmentActivity implements OnClickListener {

	private View back;
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


	}
	
	@Override
	protected void setContentLayout() {
		setContentView(R.layout.activity_main);
	};

	@Override
	protected void findViewById() {
		back = findViewById(R.id.left_img);
		title = (TextView) findViewById(R.id.title);

		title.setText("留下");

		setListener();

	};

	private void setListener() {
		back.setOnClickListener(this);
	}

	@Override
	protected void requestNet() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void setViewData() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.left_img:
			finish();
			break;

		default:
			break;
		}

	}
}
