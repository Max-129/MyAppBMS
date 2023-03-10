package com.example.myappbms.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    fun isUserSeen(): Boolean {
        return pref.getBoolean(SEEN_KEY, false)
    }

    fun saveSeen() {
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }

    fun saveName(name: String) {
        pref.edit().putString(NAME_KEY, name).apply()
    }

    fun getName(): String {
        return pref.getString(NAME_KEY, "").toString()
    }

    fun saveImage(image: String) {
        pref.edit().putString(IMG_KEY, image).apply()
    }

    fun getImage(): String {
        return pref.getString(IMG_KEY, "").toString()
    }

    companion object {
        const val PREF_NAME = "pref.task"
        const val SEEN_KEY = "seen.key"
        const val NAME_KEY = "name.key"
        const val IMG_KEY = "img.key"
    }
}