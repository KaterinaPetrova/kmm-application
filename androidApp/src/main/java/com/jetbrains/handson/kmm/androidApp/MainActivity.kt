package com.jetbrains.handson.kmm.androidApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jetbrains.handson.kmm.sdk.SpaceXSDK
import com.jetbrains.handson.kmm.sdk.database.DatabaseDriverFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        val sdk = SpaceXSDK(DatabaseDriverFactory(applicationContext))
        tv.text = sdk.getFirstLaunchName()
    }
}

