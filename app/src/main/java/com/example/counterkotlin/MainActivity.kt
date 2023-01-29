package com.example.counterkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counterkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().add(R.id.container, MainFragment()).commit()
        }
    }
}