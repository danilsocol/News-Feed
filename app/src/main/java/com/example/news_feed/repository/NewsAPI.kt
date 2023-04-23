package com.example.news_feed.repository

import com.example.news_feed.models.NewsRequest
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {

    @GET("new_text.json")
    suspend fun getNews(): Response<List<NewsRequest>>

}