package com.example.news_feed

sealed class NewsModel ( val title:  String,
                         val subtitle: String)
{
    class NewsModelImage(
        title:  String,
        subtitle: String,
        val img: String?,

        ) : NewsModel(title,subtitle)

    class NewsModelImageHasBag(
        title:  String,
        subtitle: String,
        val img: String?,
        val hasBag: String?,

        ) : NewsModel(title,subtitle)

    class NewsModelCircleImage(
        title:  String,
        subtitle: String,
        val img: String?,
        val isCircle: Boolean?

    ) : NewsModel(title,subtitle)
}