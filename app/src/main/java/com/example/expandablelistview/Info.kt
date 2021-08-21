package com.example.expandablelistview

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        btn_back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            val mediaPlayer = MediaPlayer.create(this, R.raw.juntos)
            mediaPlayer.start()
        }

        btn_media.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(this, R.raw.ringtone)
            mediaPlayer.start()
        }
    }
}