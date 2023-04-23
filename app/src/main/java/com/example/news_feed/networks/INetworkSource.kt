package com.example.news_feed.networks
import androidx.lifecycle.MutableLiveData
import com.example.news_feed.models.NewsModel


interface INetworkSource {
    fun sendData(liveData: MutableLiveData<List<NewsModel>>)
}
