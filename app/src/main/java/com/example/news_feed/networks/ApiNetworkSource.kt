package com.example.news_feed.networks

import androidx.lifecycle.MutableLiveData
import com.example.news_feed.models.NewsModel
import com.example.news_feed.repository.NewsAPI
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiNetworkSource : INetworkSource {
    override fun sendData(liveData: MutableLiveData<List<NewsModel>>) {

    }
}
