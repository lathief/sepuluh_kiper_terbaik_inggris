package com.example.sepuluhkiperterbaiktimnasinggris

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class KiperActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_IMAGE = "extra_image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kiper)

        val tvData1Received: TextView = findViewById(R.id.tv_dataname_received)
        val tvData2Received: TextView = findViewById(R.id.tv_datadetail_received)
        val imagereceived: ImageView = findViewById(R.id.image_received)
        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val text1 = "Name : $name"
        val text2 = "Karir : $detail"
        val recv: Int = intent.getIntExtra(EXTRA_IMAGE,0)
        imagereceived.setImageResource(recv)
        tvData1Received.text = text1
        tvData2Received.text = text2
    }
}
