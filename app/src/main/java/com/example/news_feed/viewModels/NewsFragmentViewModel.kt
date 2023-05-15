package com.example.news_feed.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.news_feed.models.NewsModel
import com.example.news_feed.useCase.GetAllNewsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsFragmentViewModel(private val getAllNewsUseCase: GetAllNewsUseCase) : ViewModel() {

    var liveData = MutableLiveData<List<NewsModel>>() //todo изменить на private

    fun init() {
        viewModelScope.launch{
            liveData.value = getAllNewsUseCase.execute()
        }
    }

}
class NewsFragmentViewModelFactory @Inject constructor(private val getAllNewsUseCase: GetAllNewsUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsFragmentViewModel(getAllNewsUseCase) as T
    }
}
