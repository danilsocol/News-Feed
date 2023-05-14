package com.example.news_feed.repository

import com.example.news_feed.models.NewsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface NewsRepository {
    suspend fun getNews() : List<NewsModel>
}