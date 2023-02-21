package com.example.myappbms.taskmanager.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    fun isUserSeen(): Boolean {
        return pref.getBoolean(SEEN_KEY, false)
    }

    companion object {
        const val PREF_NAME = "pref.task"
        const val SEEN_KEY = "seen.key"
    }
}