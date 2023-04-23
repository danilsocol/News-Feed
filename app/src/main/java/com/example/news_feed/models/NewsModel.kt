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

    companion object Factory {
        fun getTool(res: NewsRequest): NewsModel{
            return if (res.img == null) {
                DefaultNewsModel(res.title, res.subtitle)
            } else if (res.isCircle != null) {
                NewsModelCircleImage(res.title, res.subtitle, res.img, res.isCircle)
            } else if (res.hasBag != null) {
                NewsModelImageHasBag(res.title, res.subtitle, res.img, res.hasBag)
            } else {
                NewsModelImage(res.title, res.subtitle, res.img)
            }
        }
        fun getTools(responses: List<NewsRequest>): List<NewsModel>{
            return responses.map { getTool(it) }
        }
    }
}