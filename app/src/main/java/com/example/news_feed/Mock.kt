package com.example.news_feed

import androidx.lifecycle.MutableLiveData
import com.example.news_feed.models.NewsModel

class Mock {

    fun sendData(liveData: MutableLiveData<List<NewsModel>>) {
        val tools = getTools()
    }
    private fun getTools():List<NewsModel>{
        return listOf(
            NewsModel.DefaultNewsModel("header","subhead"),
            NewsModel.NewsModelImage("header","subhead","https://s.mediasalt.ru/images/309/309640/original.jpg"),
            NewsModel.NewsModelCircleImage("header","subhead","https://s.mediasalt.ru/images/309/309640/original.jpg",true)
        )
    }
}