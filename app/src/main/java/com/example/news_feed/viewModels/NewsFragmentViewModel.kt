package com.example.news_feed.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.news_feed.Mock
import com.example.news_feed.models.NewsModel
import com.example.news_feed.networks.ApiNetworkSource
import com.example.news_feed.networks.INetworkSource

class NewsFragmentViewModel : ViewModel() {

    val liveData = MutableLiveData<List<NewsModel>>()
    private val network: INetworkSource = ApiNetworkSource()
    public fun init() {
        network.sendData(liveData);
    }

}