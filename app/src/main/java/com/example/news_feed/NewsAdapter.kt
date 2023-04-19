package com.example.news_feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.news_feed.databinding.ViewTypeBinding
import com.example.news_feed.databinding.ViewTypeImageBinding
import com.example.news_feed.databinding.ViewTypeImageCircleBinding


class NewsAdapter() : ListAdapter<NewsModel, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            0 -> {
                val binding = ViewTypeImageBinding.inflate( // текст на картинке
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                NewsHolderImage(binding)
            }

            1 -> {
                val binding = ViewTypeImageBinding.inflate(  // текст на картинке с фоном
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                NewsHolderImageHasBag(binding)
            }

            2 -> {
                val binding = ViewTypeImageCircleBinding.inflate(  // круглая картинка
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                NewsHolderImageCircle(binding)
            }

            else -> {
                val binding = ViewTypeBinding.inflate(  // текст
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                NewsHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).viewType) {
            0 -> 0
            1 -> 1
            2 -> 2
            else -> 4
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> (holder as NewsHolderImage).bind(
                getItem(position) as NewsModel.NewsModelImage
            )

            1 -> (holder as NewsHolderImageHasBag).bind(
                getItem(position) as NewsModel.NewsModelImageHasBag
            )

            2 -> (holder as NewsHolderImageCircle).bind(
                getItem(position) as NewsModel.NewsModelCircleImage
            )

            else -> (holder as NewsHolder).bind(
                getItem(position) as NewsModel
            )
        }
    }


    class NewsHolderImage(private val binding: ViewTypeImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsModel.NewsModelImage) = with(binding) {
            header.text = news.title
            subHeader.text = news.subtitle
            /*image.setImageResource()*/ //todo скачивание картинки
        }
    }

    class NewsHolderImageHasBag(private val binding: ViewTypeImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsModel.NewsModelImageHasBag) = with(binding) {
            header.text = news.title
            subHeader.text = news.subtitle
            /*containerText.setBackgroundColor(news.hasBag) */ //todo изменить цвет
            /*image.setImageResource()*/ //todo скачивание картинки
        }
    }

    class NewsHolderImageCircle(private val binding: ViewTypeImageCircleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsModel.NewsModelCircleImage) = with(binding) {
            header.text = news.title
            subHeader.text = news.subtitle
            /*image.setImageResource()*/ //todo скачивание картинки
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