package com.example.news_feed.di

import com.example.news_feed.repository.NewsRepository
import com.example.news_feed.repository.NewsRepositoryImpl
import com.example.news_feed.retrofit.NewsAPI
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NewsModule {

    @Binds
    abstract fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}