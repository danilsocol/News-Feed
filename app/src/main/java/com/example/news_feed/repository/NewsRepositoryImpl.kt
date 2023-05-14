package com.example.news_feed.repository

import androidx.lifecycle.MutableLiveData
import com.example.news_feed.models.NewsModel
import com.example.news_feed.retrofit.NewsAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsApi: NewsAPI) : NewsRepository { //todo нужен ли inject

    //val liveData = MutableLiveData<List<NewsModel>>()

    override suspend fun getNews(): List<NewsModel> {
        val response = withContext(Dispatchers.IO) {
            newsApi.getNews()
        }
        if (response.isSuccessful) {
            val responses = response.body()
            val news = responses?.let { NewsModel.getAllNews(it) }
            return news!!
        }
        throw Exception()
    }

}