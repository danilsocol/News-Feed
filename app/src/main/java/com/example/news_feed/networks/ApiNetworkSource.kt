package com.example.news_feed.networks

import com.example.news_feed.models.NewsRequest
import com.example.news_feed.retrofit.NewsAPI
import retrofit2.Response
import javax.inject.Inject

class ApiNetworkSource : INetworkSource {

    @Inject
    lateinit var newsApi: NewsAPI
    override suspend fun sendData() : Response<List<NewsRequest>>
    {
        return newsApi.getNews()
    }
}

