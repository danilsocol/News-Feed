package com.example.news_feed.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.news_feed.models.NewsModel
import com.example.news_feed.repository.NewsRepository
import com.example.news_feed.retrofit.NewsAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsFragmentViewModel(private val repository: NewsRepository) : ViewModel() {

    val liveData : MutableLiveData<List<NewsModel>>
        get() = repository.liveData
    fun init() {
        viewModelScope.launch{
           repository.getNews()
        }
    }

}
class NewsFragmentViewModelFactory @Inject constructor(private val repository: NewsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsFragmentViewModel(repository) as T
    }
}
