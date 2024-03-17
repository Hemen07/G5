package com.example.g5.ui.base

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.g5.R


/**
 * Base class for activity
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * Abstract to Get the toolbar title.
     *
     * @return
     */
    abstract fun getToolbarTitle(): String

    /**
     * OnStart
     *
     * 1. Setting up the toolbar
     * 2. Setting up the Home back button
     */
    override fun onStart() {
        super.onStart()
        setToolbarTitle(getToolbarTitle())
        getUpButton().setOnClickListener {
            finish()
        }
    }

    /**
     * Set toolbar title
     */
    private fun setToolbarTitle(toolbarTitle: String) {
        getToolbar().text = toolbarTitle
    }

    /**
     * Get up button
     */
    private fun getUpButton(): ImageView = findViewById(R.id.btnToolbarBack)

    /**
     * Get toolbar
     */
    private fun getToolbar(): TextView = findViewById(R.id.toolbarTitle)
}