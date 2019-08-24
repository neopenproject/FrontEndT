package com.hackathon.co.kr.neopenproject.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

object SharedUtil {

    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    val TOKEN_KEY = "TOKEN_KEY"
    val TOKEN_DEFAULT_VALUE = "NONE"

    fun sharedPreferenceInit(context: Context) {
        sharedPreferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
        editor!!.apply()
    }

    fun getStringData(key: String): String? {
        return sharedPreferences?.getString(key, "")
    }

    fun getIntegerData(key: String): Int {
        return sharedPreferences!!.getInt(key, -1)
    }

    fun getFloatData(key: String): Float {
        return sharedPreferences!!.getFloat(key, 0f)
    }

    fun getBooleanData(key: String): Boolean {
        return sharedPreferences!!.getBoolean(key, false)
    }

    fun setData(key: String, value: String) {
        editor!!.putString(key, value)
        editor!!.commit()
    }

    fun setData(key: String, value: Int) {
        editor!!.putInt(key, value)
        editor!!.commit()
    }

    fun setData(key: String, value: Float) {
        editor!!.putFloat(key, value)
        editor!!.commit()
    }

    fun setData(key: String, value: Boolean) {
        editor!!.putBoolean(key, value)
        editor!!.commit()
    }
}