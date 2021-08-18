package com.dev.splashapp

import androidx.appcompat.app.AppCompatDelegate
import java.lang.reflect.Field

object Utils {

    fun setThemeWithoutRecreate(mode: Int) {
        setFieldValue(AppCompatDelegate::class.java, "sDefaultNightMode", mode)
    }

    private fun getField(clazz: Class<*>, fieldName: String): Field? {
        try {
            return clazz.getDeclaredField(fieldName)
        } catch (e: NoSuchFieldException) {
            throw RuntimeException("Can't get " + fieldName + " of " + clazz.name)
        }
    }

    private fun setFieldValue(clazz: Class<*>, fieldName: String, value: Any) {
        getField(clazz, fieldName)?.apply {
            isAccessible = true
            set(fieldName, value)
        }
    }
}