package com.example.news_feed.repository

import dagger.Component


@Component(modules = [RetrofitBuilder::class])
interface ApiComponent {
    fun getApiService(): NewsAPI
}
