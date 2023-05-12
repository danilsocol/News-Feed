package com.example.news_feed.networks

import com.example.news_feed.models.NewsRequest
import com.example.news_feed.repository.NewsAPI
import com.example.news_feed.repository.RetrofitBuilder
import retrofit2.Response

class ApiNetworkSource : INetworkSource {

    private val retrofit = RetrofitBuilder.getClient()
    private val api = retrofit!!.create(NewsAPI::class.java)
    override suspend fun sendData() : Response<List<NewsRequest>>
    {
        return api.getNews()
    }
}

