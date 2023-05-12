package com.example.news_feed.di

import com.example.news_feed.repository.NewsAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    private var retrofit: Retrofit? = null

    @Provides
    fun getRetrofit( baseUrl : String): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

    @Provides
    fun getApi(retrofit: Retrofit) : NewsAPI {
        return retrofit.create(NewsAPI::class.java)
    }
}