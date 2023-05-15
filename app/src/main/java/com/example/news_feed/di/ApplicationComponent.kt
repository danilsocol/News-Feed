package com.example.news_feed.di

import com.example.news_feed.MainActivity
import com.example.news_feed.NewsListFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, UseCaseModule::class, NewsModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: NewsListFragment)
}