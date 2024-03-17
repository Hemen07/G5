package com.example.g5.ui.features.two

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import coil.load
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.g5.R
import com.example.g5.domain.entities.responses.ClientGithub
import dagger.hilt.android.qualifiers.ActivityContext

private const val TAG = "G5-MyCustomDialog : "

/**
 * My custom dialog
 * Nothing just more
 * TODO : DI this as well
 */
class MyCustomDialog(@ActivityContext private val activity: Activity) {

    fun showDialog(clientGithub: ClientGithub) {
        val builder = AlertDialog.Builder(activity)
        val layout = activity.layoutInflater.inflate(R.layout.my_custom_dialog, null)
        builder.setView(layout)
        //
        val tvAuthor = layout.findViewById<TextView>(R.id.tvTitle)
        val imageView = layout.findViewById<ImageView>(R.id.img_my_custom_dialog)
        val loadButton = layout.findViewById<Button>(R.id.btn_load_my_custom_dialog)
        val okButton = layout.findViewById<Button>(R.id.btn_ok_my_custom_dialog)
        //
        val dialog = builder.create()
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.show()

        tvAuthor.text = clientGithub.username.ifEmpty { "Avatar" }
        if (clientGithub.avatar.isEmpty()) {
            imageView.load(
                "https://www.mohenesh.com/wp-content/uploads/2021/11/Doge-meme-2-1024x614.webp",
                builder = {
                    setImageConfig(imageBuilder = this)
                })
        } else {
            imageView.load(
                clientGithub.avatar,
                builder = {
                    setImageConfig(imageBuilder = this)
                })
        }

        loadButton.setOnClickListener {
            Log.w(TAG, "showDialog: ||| LOAD ||| btn")
            tvAuthor.text = "Hemen"
            imageView.load(
                "https://avatars.githubusercontent.com/u/6644894?s=400&u=5a61501fad82cb4a89d0aa0998653ab11d857b79&v=4",
//                "https://www.mohenesh.com/wp-content/uploads/2021/11/Doge-meme-2-1024x614.webp",
                builder = {
                    setImageConfig(imageBuilder = this)
                })
        }
        okButton.setOnClickListener {
            Log.w(TAG, "showDialog: ||| OKAY ||| btn")
            dialog.dismiss()
        }
    }

    private fun setImageConfig(imageBuilder: ImageRequest.Builder) {
        imageBuilder.crossfade(true)
        imageBuilder.placeholder(R.drawable.shape_default)
        imageBuilder.transformations(CircleCropTransformation())
    }
}