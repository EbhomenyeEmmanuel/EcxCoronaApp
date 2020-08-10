package com.esq.ecxcoronaapp.ui.bottom_nav

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.esq.ecxcoronaapp.R
import com.esq.ecxcoronaapp.data.NewsFragmentAdapter
import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment : Fragment() {

    private lateinit var adapter: NewsFragmentAdapter
    private lateinit var recyclerView: RecyclerView

    companion object {
        private val TAG = this::class.simpleName
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        recyclerView = news_recycler_view
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        viewModel.homeAdapterData.observe(viewLifecycleOwner, Observer {
            it.let {
                adapter = NewsFragmentAdapter(activity?.applicationContext!!, it)
                recyclerView.adapter = adapter
            }
        })

    }

}
