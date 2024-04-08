package com.example.g5.di.activity

import android.app.Activity
import com.example.g5.ui.features.two.MyCustomDialog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

private const val TAG = "G5-ActivityModule : "

/**
 * Activity module
 *
 */
@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    /**
     * Provide my custom dialog
     *
     * @param activity
     * @return [MyCustomDialog]
     */
    @Provides
    fun provideMyCustomDialog(activity: Activity): MyCustomDialog = MyCustomDialog(activity)

}