package com.example.sunnyweather

import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application() {
    companion object {
        @SuppressWarnings("StaticFieldLeak")
        lateinit var context: Context

        const val TOKEN = "id4pOBZbS3w1yHsa"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}