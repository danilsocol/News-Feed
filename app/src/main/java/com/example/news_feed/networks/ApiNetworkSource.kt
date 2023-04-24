package com.example.news_feed.networks

import androidx.lifecycle.MutableLiveData
import com.example.news_feed.models.NewsModel
import com.example.news_feed.repository.NewsAPI
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiNetworkSource : INetworkSource {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://develtop.ru/study/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val newsApi = retrofit.create(NewsAPI::class.java)

    override fun sendData(liveData: MutableLiveData<List<NewsModel>>){
        GlobalScope.launch {
            val response = newsApi.getNews()

            if (response.isSuccessful) {
                val responses = response.body()
                val news = responses?.let { NewsModel.getAllNews(it) }
                liveData.postValue(news)
            }
        }
    }
}