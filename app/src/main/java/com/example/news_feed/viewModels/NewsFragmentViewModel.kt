package com.example.news_feed.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.news_feed.models.NewsModel
import com.example.news_feed.repository.NewsAPI
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsFragmentViewModel : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://develtop.ru/study/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val liveData = MutableLiveData<List<NewsModel>>()
    private val newsApi = retrofit.create(NewsAPI::class.java)


    public fun downloadData() {
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