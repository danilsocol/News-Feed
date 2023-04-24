package com.example.news_feed.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.news_feed.R
import com.example.news_feed.models.NewsModel
import com.example.news_feed.databinding.ViewTypeBinding
import com.example.news_feed.databinding.ViewTypeImageBinding
import com.example.news_feed.databinding.ViewTypeImageCircleBinding
import com.squareup.picasso.Picasso


class NewsListAdapter() : ListAdapter<NewsModel, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            R.layout.view_type_image -> {
                val binding = ViewTypeImageBinding.inflate( // текст на картинке
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                NewsHolderImage(binding)
            }

            R.layout.view_type_image_hasbag -> {
                val binding = ViewTypeImageBinding.inflate(  // текст на картинке с фоном
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                NewsHolderImageHasBag(binding)
            }

            R.layout.view_type_image_circle -> {
                val binding = ViewTypeImageCircleBinding.inflate(  // круглая картинка
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                NewsHolderImageCircle(binding)
            }

            R.layout.view_type -> {
                val binding = ViewTypeBinding.inflate(  // текст
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                NewsHolder(binding)
            }

            else -> throw IllegalStateException("Неизвестный тип $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is NewsModel.NewsModelImage -> R.layout.view_type_image
            is NewsModel.NewsModelImageHasBag -> R.layout.view_type_image_hasbag
            is NewsModel.NewsModelCircleImage -> R.layout.view_type_image_circle
            is NewsModel.DefaultNewsModel -> R.layout.view_type
            else -> Int.MAX_VALUE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.layout.view_type_image -> (holder as NewsHolderImage).bind(
                getItem(position) as NewsModel.NewsModelImage
            )

            R.layout.view_type_image_hasbag -> (holder as NewsHolderImageHasBag).bind(
                getItem(position) as NewsModel.NewsModelImageHasBag
            )

            R.layout.view_type_image_circle -> (holder as NewsHolderImageCircle).bind(
                getItem(position) as NewsModel.NewsModelCircleImage
            )

            R.layout.view_type -> (holder as NewsHolder).bind(
                getItem(position) as NewsModel.DefaultNewsModel
            )
            else -> throw IllegalStateException("Неизвестный тип ${holder.itemViewType}")
        }
    }

    class NewsHolderImage(private val binding: ViewTypeImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsModel.NewsModelImage) = with(binding) {
            header.text = news.title
            subHeader.text = news.subtitle
            Picasso.get().load(news.img)
                .placeholder(R.drawable.animeted_loading)
                .error(R.drawable.ic_broken_image)
                .into(image)
        }
    }

    class NewsHolderImageHasBag(private val binding: ViewTypeImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsModel.NewsModelImageHasBag) = with(binding) {
            header.text = news.title
            subHeader.text = news.subtitle

            val color = Color.parseColor(news.hasBag)
            containerText.setBackgroundColor(color)

            Picasso.get().load(news.img)
                .placeholder(R.drawable.animeted_loading)
                .error(R.drawable.ic_broken_image)
                .into(image)
        }
    }

    class NewsHolderImageCircle(private val binding: ViewTypeImageCircleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsModel.NewsModelCircleImage) = with(binding) {
            header.text = news.title
            subHeader.text = news.subtitle
            Picasso.get().load(news.img)
                .placeholder(R.drawable.animeted_loading)
                .error(R.drawable.ic_broken_image)
                .into(image)
        }
    }

    class NewsHolder(private val binding: ViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsModel) = with(binding) {
            header.text = news.title
            subHeader.text = news.subtitle
        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<NewsModel>() {

        override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
            return oldItem == newItem
        }
    }
}