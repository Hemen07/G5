package com.example.g5.application

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

private const val TAG = "G5-MyApp : "

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ||||||||||||||||  HILT   |||||||||||||||||||||||||||||||")
    }
}