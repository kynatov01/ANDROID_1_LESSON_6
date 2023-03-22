package com.example.android_1_lesson_6.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_1_lesson_6.R

import com.example.android_1_lesson_6.ui.fragments.CatFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view,CatFragment())
            .commit()

    }
}