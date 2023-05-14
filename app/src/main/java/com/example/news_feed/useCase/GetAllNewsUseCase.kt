package com.example.news_feed.useCase

import com.example.news_feed.models.NewsModel
import com.example.news_feed.repository.NewsRepository

class GetAllNewsUseCase(private val repository: NewsRepository) {

    suspend fun execute(): List<NewsModel>
    {
        return repository.getNews()
    }
}