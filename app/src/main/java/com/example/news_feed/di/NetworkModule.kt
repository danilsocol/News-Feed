package com.example.news_feed.di

import com.example.news_feed.repository.NewsRepository
import com.example.news_feed.repository.NewsRepositoryImpl
import com.example.news_feed.retrofit.NewsAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGetRetrofit( ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://develtop.ru/study/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideGetApi(retrofit: Retrofit) : NewsAPI {
        return retrofit.create(NewsAPI::class.java)
    }

}