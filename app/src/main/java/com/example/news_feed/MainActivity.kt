package com.example.news_feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news_feed.databinding.ActivityMainBinding
import com.example.news_feed.repository.RetrofitBuilder

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}