package com.example.news_feed.networks
import androidx.lifecycle.MutableLiveData
import com.example.news_feed.models.NewsModel
import com.example.news_feed.models.NewsRequest
import retrofit2.Response


interface INetworkSource {
    suspend fun sendData(): Response<List<NewsRequest>>
}
