package com.dev.splashapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dev.splashapp.Utils.setThemeWithoutRecreate

const val IS_NIGHT_THEME_ARG = "IS_NIGHT_THEME"
const val SHARED_PREFERENCES_ARG = "SETTINGS"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences(SHARED_PREFERENCES_ARG, Context.MODE_PRIVATE)
        findViewById<Button>(R.id.btnLight).setOnClickListener {
            setThemeWithoutRecreate(MODE_NIGHT_NO)
            sp.edit().putBoolean(IS_NIGHT_THEME_ARG, false).apply()
            recreate()
        }
        findViewById<Button>(R.id.btnNight).setOnClickListener {
            setThemeWithoutRecreate(MODE_NIGHT_YES)
            sp.edit().putBoolean(IS_NIGHT_THEME_ARG, true).apply()
            recreate()
        }
    }

    override fun recreate() {
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        startActivity(Intent(this, MainActivity::class.java))
    }
}