package com.example.news_feed

import android.app.Application
import com.example.news_feed.di.ApplicationComponent
import com.example.news_feed.di.DaggerApplicationComponent


class NewsApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}