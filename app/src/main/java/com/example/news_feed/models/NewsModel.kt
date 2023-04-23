package com.example.news_feed.models

sealed class NewsModel (
    open val title:  String,
    open val subtitle: String)
{
    data class DefaultNewsModel(
        override val title:  String,
        override val subtitle: String,
    ) : NewsModel(title, subtitle)
    data class NewsModelImage(
        override val title:  String,
        override val subtitle: String,
        val img: String?,

        ) : NewsModel(title,subtitle)

    data class NewsModelImageHasBag(
        override val title:  String,
        override val subtitle: String,
        val img: String?,
        val hasBag: String?,

        ) : NewsModel(title,subtitle)

    data class NewsModelCircleImage(
        override val title:  String,
        override val subtitle: String,
        val img: String?,
        val isCircle: Boolean?

    ) : NewsModel(title,subtitle)
}