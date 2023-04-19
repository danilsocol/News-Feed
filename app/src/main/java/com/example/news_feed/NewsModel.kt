package com.example.news_feed

sealed class NewsModel (
    val viewType: Int,
    val title:  String,
    val subtitle: String)
{
    class NewsModelImage(
        viewType: Int,
        title:  String,
        subtitle: String,
        val img: String?,

        ) : NewsModel(viewType,title,subtitle)

    class NewsModelImageHasBag(
        viewType: Int,
        title:  String,
        subtitle: String,
        val img: String?,
        val hasBag: String?,

        ) : NewsModel(viewType,title,subtitle)

    class NewsModelCircleImage(
        viewType: Int,
        title:  String,
        subtitle: String,
        val img: String?,
        val isCircle: Boolean?

    ) : NewsModel(viewType,title,subtitle)
}