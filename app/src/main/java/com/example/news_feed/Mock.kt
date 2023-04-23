package com.example.news_feed

import androidx.lifecycle.MutableLiveData
import com.example.news_feed.models.NewsModel
import com.example.news_feed.networks.INetworkSource

class Mock : INetworkSource {
    override fun sendData(liveData: MutableLiveData<List<NewsModel>>) {
        val tools = getTools()
        liveData.postValue(tools)
    }
    private fun getTools():List<NewsModel>{
        return listOf(
            NewsModel.DefaultNewsModel("header","gay"),
/*            NewsModel.NewsModelImage("header","gay","https://drive.google.com/file/u/1/d/1oA9C6t28y5i1jtDIXc5vUvmG_ZAqeGKX/view?usp=drive_open"),
            NewsModel.NewsModelCircleImage("Hello","Hello","https://drive.google.com/file/u/1/d/1oA9C6t28y5i1jtDIXc5vUvmG_ZAqeGKX/view?usp=drive_open",true)*/
        )
    }
}