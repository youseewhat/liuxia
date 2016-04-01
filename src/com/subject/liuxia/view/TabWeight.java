package com.subject.liuxia.view;

import java.util.ArrayList;

import com.subject.liuxia.R;
import com.subject.liuxia.utils.CommonUtis;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * 首页底部Weight
 * @author YY
 *
 */
public class TabWeight extends LinearLayout {

	private static final String TAG = "TabWeight";

	private int[] icons = { R.drawable.main_home_icon, R.drawable.add_publish_normal, R.drawable.main_me_icon };
	private ArrayList<String> labels = new ArrayList<String>();
	
	private AttributeSet mAttrs;
	private Context mContext;

	private int padding;

	public TabWeight(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init(context, attrs, defStyleAttr);
	}

	public TabWeight(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		init(context, attrs, defStyleAttr);

	}

	public TabWeight(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs, 0);
	}

	private void init(Context context, AttributeSet attrs, int defStyleAttr) {
		this.mAttrs = attrs;
		this.mContext = context;
		
		setBackgroundResource(R.drawable.weight_white_bg);
		padding = CommonUtis.dp2px(mContext, 8);
		
		TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Tab_Weight, defStyleAttr,
				0);
		CharSequence[] array = typedArray.getTextArray(R.styleable.Tab_Weight_tab_label);
		labels.clear();
		for (int i = 0; i < array.length; i++) {
			labels.add(array[i].toString());
		}
		typedArray.recycle();
		
		LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		params.gravity = Gravity.CENTER;
		params.weight = 1.0f;
		
		
		for (int i = 0; i < labels.size(); i++) {
			View view = View.inflate(getContext(), R.layout.weight_item, null);
			TextView itemName = (TextView) view.findViewById(R.id.item_name);
			
			itemName.setText(labels.get(i));
			
			itemName.setCompoundDrawablePadding(2);
			itemName.setGravity(Gravity.CENTER);
//			view.setPadding(0, padding, 0, padding);
			itemName.setCompoundDrawablesWithIntrinsicBounds(0, icons[i], 0, 0);
			
			addView(view,params);
			
			
		}
		
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);

		int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

		if (widthSpecMode != MeasureSpec.EXACTLY) {
			widthSpecSize = 0;
		}

		if (heightSpecMode != MeasureSpec.EXACTLY) {
			heightSpecSize = 0;
		}

		if (widthSpecMode == MeasureSpec.UNSPECIFIED
				|| heightSpecMode == MeasureSpec.UNSPECIFIED) {
		}

		// 控件的最大高度，就是下边tab的背景最大高度
		int width;
		int height;
		width = Math.max(getMeasuredWidth(), widthSpecSize);
		height = Math.max(getMeasuredHeight(), heightSpecSize);
		setMeasuredDimension(width, height);
	}
}
