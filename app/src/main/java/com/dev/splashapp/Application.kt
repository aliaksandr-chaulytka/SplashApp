package com.dev.splashapp

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.dev.splashapp.Utils.setThemeWithoutRecreate

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        val sp = getSharedPreferences(SHARED_PREFERENCES_ARG, Context.MODE_PRIVATE)
        val isNightTheme = sp.getBoolean(IS_NIGHT_THEME_ARG, false)
        setThemeWithoutRecreate(if (isNightTheme) MODE_NIGHT_YES else MODE_NIGHT_NO)
    }
}