package com.subject.liuxia.utils;

import android.util.Log;

/**
 * @author YY
 */
public class LogUtils {

	private static final String TAG = "LogUtils";

	// 正式环境要切换成false
	public static final boolean IS_DEBUG = true;

	public static void v(String tag, String msg) {
		if (IS_DEBUG) {
			Log.v(TAG, tag + "-->" + msg);
		}
	}

	public static void d(String tag, String msg) {
		if (IS_DEBUG) {
			Log.d(TAG, tag + "-->" + msg);
		}
	}

	public static void i(String tag, String msg) {
		if (IS_DEBUG) {
			Log.i(TAG, tag + "-->" + msg);
		}
	}

	public static void w(String tag, String msg) {
		if (IS_DEBUG) {
			Log.v(TAG, tag + "-->" + msg);
		}
	}

	public static void e(String tag, String msg) {
		if (IS_DEBUG) {
			Log.e(TAG, tag + "-->" + msg);
		}
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (IS_DEBUG) {
			Log.e(TAG, tag + "-->" + msg);
		}
	}
}
