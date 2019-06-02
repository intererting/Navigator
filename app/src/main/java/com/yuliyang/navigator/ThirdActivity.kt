package com.yuliyang.navigator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
    }

    override fun onResume() {
        super.onResume()
        println("HostFragment $homeNavigator")
        text.text = intent.getStringExtra("name")
        navback.setOnClickListener {
            navigateUpTo(Intent(this, MainActivity::class.java))
        }
    }
}