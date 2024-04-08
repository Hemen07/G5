package com.example.g5.ui.features.two

import android.app.Activity
import android.app.AlertDialog
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.g5.R
import dagger.hilt.android.qualifiers.ActivityContext

private const val TAG = "G5-MyCustomDialog : "

class MyCustomDialog(@ActivityContext private val activity: Activity) {

    fun showDialog() {
        Log.d(TAG, "showDialog: activity = ${activity.componentName}")
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("C O I L ")
        val layout = activity.layoutInflater.inflate(R.layout.my_custom_dialog, null)
        builder.setView(layout)
        //
        val imageView = layout.findViewById<ImageView>(R.id.img_my_custom_dialog)
        val loadButton = layout.findViewById<Button>(R.id.btn_load_my_custom_dialog)
        val okButton = layout.findViewById<Button>(R.id.btn_ok_my_custom_dialog)
        //
        val dialog = builder.create()
        dialog.setCancelable(false)
        dialog.show();

        //
        loadButton.setOnClickListener {
            Log.w(TAG, "showDialog: ||| LOAD ||| btn")
            imageView.load("https://www.mohenesh.com/wp-content/uploads/2021/11/Doge-meme-2-1024x614.webp") {
                crossfade(true)
                placeholder(R.drawable.shape_default)
                transformations(CircleCropTransformation())
            }

        }
        okButton.setOnClickListener {
            Log.w(TAG, "showDialog: ||| OKAY ||| btn")
            dialog.dismiss()
        }
    }

}