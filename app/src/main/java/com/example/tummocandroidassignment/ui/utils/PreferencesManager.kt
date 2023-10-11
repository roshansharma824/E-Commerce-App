package com.example.tummocandroidassignment.ui.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {



    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveData(key: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getData(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }
}