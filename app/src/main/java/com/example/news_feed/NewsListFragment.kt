package com.example.news_feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_feed.adapters.NewsListAdapter
import com.example.news_feed.databinding.FragmentNewsListBinding
import com.example.news_feed.models.NewsModel
import com.example.news_feed.viewModels.NewsFragmentViewModel
import com.example.news_feed.viewModels.NewsFragmentViewModelFactory
import javax.inject.Inject

class NewsListFragment : Fragment() {

    private var _binding: FragmentNewsListBinding? = null
    private val newsAdapter = NewsListAdapter()

    @Inject
    lateinit var viewModelFactory: NewsFragmentViewModelFactory
    private lateinit var viewModel : NewsFragmentViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)

        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        (activity?.application as NewsApplication).applicationComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsFragmentViewModel::class.java)

        binding.rcView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        binding.rcView.adapter = newsAdapter

        val observer = Observer<List<NewsModel>> { newValue ->
            newsAdapter.submitList(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}