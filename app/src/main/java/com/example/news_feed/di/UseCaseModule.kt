package com.example.news_feed.di

import com.example.news_feed.repository.NewsRepository
import com.example.news_feed.retrofit.NewsAPI
import com.example.news_feed.useCase.GetAllNewsUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetAllNewsUseCase(repository: NewsRepository) : GetAllNewsUseCase{
        return GetAllNewsUseCase(repository)
    }
}
