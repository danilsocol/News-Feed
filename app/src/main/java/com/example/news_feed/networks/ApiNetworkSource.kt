package com.example.news_feed.networks

import androidx.lifecycle.MutableLiveData
import com.example.news_feed.models.NewsModel
import com.example.news_feed.models.NewsRequest
import com.example.news_feed.repository.RetrofitBuilder
import retrofit2.Response

class ApiNetworkSource : INetworkSource {
    override suspend fun sendData() : Response<List<NewsRequest>>
    {
        return RetrofitBuilder.newsApi.getNews()
    }
}
