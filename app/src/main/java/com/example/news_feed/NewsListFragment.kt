package com.example.news_feed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_feed.adapters.NewsListAdapter
import com.example.news_feed.databinding.FragmentNewsListBinding
import com.example.news_feed.models.NewsModel
import com.example.news_feed.viewModels.NewsFragmentViewModel

class NewsListFragment : Fragment() {

    private var _binding: FragmentNewsListBinding? = null
    private val newsAdapter = NewsListAdapter()
    private val viewModel = NewsFragmentViewModel()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)

        init()
        viewModel.init()
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    private fun init() {
        binding.rcView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        binding.rcView.adapter = newsAdapter

        val observer = Observer<List<NewsModel>> { newValue ->
            Log.d("value", newValue.toString())
            newsAdapter.submitList(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}