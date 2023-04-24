package com.example.news_feed.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_feed.models.NewsModel
import com.example.news_feed.networks.ApiNetworkSource
import com.example.news_feed.networks.INetworkSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsFragmentViewModel : ViewModel() {

    val liveData = MutableLiveData<List<NewsModel>>()
    private val network: INetworkSource = ApiNetworkSource()
    fun init() {
        viewModelScope.launch{
            val response = withContext(Dispatchers.IO) {
                network.sendData()
            }
            if (response.isSuccessful) {
                val responses = response.body()
                val news = responses?.let { NewsModel.getAllNews(it) }
                liveData.postValue(news)
            }
        }
    }

}