package com.example.news_feed.models

data class NewsRequest(
    val title: String = "",
    val subtitle: String = "",
    val img: String? = null,
    val hasBag: String? = null,
    val isCircle: Boolean? = null,
){}