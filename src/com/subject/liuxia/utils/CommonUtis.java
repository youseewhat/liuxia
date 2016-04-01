package com.subject.liuxia.utils;

import android.content.Context;
/**
 * 普通工具类
 * @author YY
 *
 */

public class CommonUtis {

	public static int dp2px(Context context, float dp) {
		float density = context.getResources().getDisplayMetrics().density;
		
		return (int) (dp * density + 0.5f);
	}

	public static int sp2px(Context context, int sp) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		
		return (int) (sp * fontScale + 0.5f);
	}
}
