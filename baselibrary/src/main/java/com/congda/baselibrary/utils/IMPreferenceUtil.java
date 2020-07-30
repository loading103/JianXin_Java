package com.congda.baselibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class IMPreferenceUtil {
	/**
	 * 保存Preference的name
	 */
	public static final String PREFERENCE_NAME = "saveInfo_user";
	public static final String PREFERENCE_NAME_NODELETE = "saveInfo_user_noclean";

	private static IMPreferenceUtil mPreferencemManager;

	private static SharedPreferences mSharedPreferences;
	private static SharedPreferences.Editor editor;

	private static SharedPreferences mSharedPreferences_noclean;
	private static SharedPreferences.Editor editor_noclean;

	private IMPreferenceUtil(Context cxt) {
		mSharedPreferences = cxt.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		editor = mSharedPreferences.edit();
		mSharedPreferences_noclean = cxt.getSharedPreferences(PREFERENCE_NAME_NODELETE, Context.MODE_PRIVATE);
		editor_noclean = mSharedPreferences_noclean.edit();
	}

	public static synchronized void init(Context cxt){
	    if(mPreferencemManager == null){
	        mPreferencemManager = new IMPreferenceUtil(cxt);
	    }
	}
	
	/**
	 * 单例模式，获取instance实例
	 * 
	 * @return
	 */
	public synchronized static IMPreferenceUtil getInstance() {
		if (mPreferencemManager == null) {
			throw new RuntimeException("please init first!");
		}
		
		return mPreferencemManager;
	}
	
	/**
	 * @param
	 */
	public static void setPreference_Float(String key, Float aFloat) {
		editor.putFloat(key, aFloat);
		editor.apply();
	}
	
	/**
	 * @return
	 */
	public static float getPreference_Float(String key, Float aFloat) {
		return mSharedPreferences.getFloat(key,aFloat);
	}



	/**
	 * @return
	 */
	public static String getPreference_String(String key, String value) {
		return mSharedPreferences.getString(key,value);
	}
	/**
	 * @param
	 */
	public static void setPreference_String(String key, String value) {
		editor.putString(key, value);
		editor.apply();

	}
	/**
	 * @return
	 */
	public static boolean getPreference_Boolean(String key, boolean value) {
		return mSharedPreferences.getBoolean(key,value);
	}
	/**
	 * @param
	 */
	public static void setPreference_Boolean(String key, boolean value) {
		editor.putBoolean(key, value);
		editor.apply();
	}

	/**
	 * @return
	 */
	public static String getPreference_NocleanString(String key, String value) {
		return mSharedPreferences_noclean.getString(key,value);
	}
	/**
	 * @param
	 */
	public static void setPreference_NocleanString(String key, String value) {
		editor_noclean.putString(key, value);
		editor_noclean.apply();

	}
	/**
	 * @return
	 */
	public static boolean getPreference_NocleanBoolean(String key, boolean value) {
		return mSharedPreferences_noclean.getBoolean(key,value);
	}
	/**
	 * @param
	 */
	public static void setPreference_NocleanBoolean(String key, boolean value) {
		editor_noclean.putBoolean(key, value);
		editor_noclean.apply();
	}

	public static void clean() {
		editor.clear();
		editor.apply();
		editor.commit();
	}

	public static void noClean() {
		editor_noclean.clear();
		editor_noclean.apply();
		editor_noclean.commit();
	}
}
