package com.subject.liuxia.utils;

import java.util.Iterator;
import java.util.Stack;

import com.subject.liuxia.activity.MainActivity;

import android.app.Activity;

public class ActivitiesManager {

	private static final String TAG = "ActivitiesManager";
	private static Stack<Activity> mActivityStack;
	private static ActivitiesManager mActivitiesManager;

	private ActivitiesManager() {

	}

	public static ActivitiesManager getInstance() {
		if (null == mActivitiesManager) {
			mActivitiesManager = new ActivitiesManager();
			if (null == mActivityStack) {
				mActivityStack = new Stack<Activity>();
			}
		}
		return mActivitiesManager;
	}

	public int stackSize() {
		return mActivityStack.size();
	}

	public Activity getCurrentActivity() {
		Activity activity = null;

		try {
			activity = mActivityStack.lastElement();
		} catch (Exception e) {
			return null;
		}

		return activity;
	}

	public void popActivity() {
		Activity activity = mActivityStack.lastElement();
		if (null != activity) {
			activity.finish();
			mActivityStack.remove(activity);
			activity = null;
		}
	}

	public void popActivity(Activity activity) {
		if (null != activity) {
			LogUtils.i(TAG, "popActivity-->" + activity.getClass().getSimpleName());
			mActivityStack.remove(activity);
			activity = null;
		}
	}

	public void pushActivity(Activity activity) {
		mActivityStack.add(activity);
		LogUtils.i(TAG, "pushActivity-->" + activity.getClass().getSimpleName());
	}

	public void popAllActivities() {
		while (!mActivityStack.isEmpty()) {
			Activity activity = getCurrentActivity();
			if (null == activity) {
				break;
			}
			activity.finish();
			popActivity(activity);
		}
	}

	public void popSpecialActivity(Class<?> cls) {
		try {
			Iterator<Activity> iterator = mActivityStack.iterator();
			Activity activity = null;
			while (iterator.hasNext()) {
				activity = iterator.next();
				if (activity.getClass().equals(cls)) {
					activity.finish();
					iterator.remove();
					activity = null;
				}
			}
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * 除了cls外其他都关闭
	 */
	public void popExceptActivity(Class<?> cls) {
		try {
			Iterator<Activity> iterator = mActivityStack.iterator();
			Activity activity = null;
			while (iterator.hasNext()) {
				activity = iterator.next();
				if (!activity.getClass().equals(cls)) {
					activity.finish();
					iterator.remove();
					activity = null;
				}
			}
		} catch (Exception e) {
			
		}
	}

	public void peekActivity() {
		for (Activity activity : mActivityStack) {
			if (null == activity) {
				break;
			}
		}
	}
	
	public boolean isMainExist() {
		boolean exist = false;
		try {
			Iterator<Activity> iterator = mActivityStack.iterator();
			Activity activity = null;
			while (iterator.hasNext()) {
				activity = iterator.next();
				if (activity.getClass().getSimpleName().equals(MainActivity.class.getSimpleName())) {
					exist = true;
				}
			}
		} catch (Exception e) {
			exist = false;
		}
		return exist;
	}
	
}