package com.yuliyang.navigator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavGraphNavigator
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        text.text = intent.getStringExtra("name")
    }

    override fun onResume() {
        super.onResume()
        println("HostFragment $homeNavigator")
        activityToActivity.setOnClickListener {
            val destination = ActivityNavigator.Destination(homeNavigator)
                    .setIntent(Intent(this, ThirdActivity::class.java))
            homeNavigator.navigate(destination,
                    bundleOf("name" to "lx"),
                    NavOptions.Builder().setLaunchSingleTop(true).build(),
                    ActivityNavigator.Extras.Builder().build())
        }
    }
}