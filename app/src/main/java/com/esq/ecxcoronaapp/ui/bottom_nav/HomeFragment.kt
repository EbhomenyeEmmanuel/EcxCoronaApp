package com.esq.ecxcoronaapp.ui.bottom_nav

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esq.ecxcoronaapp.R
import com.esq.ecxcoronaapp.data.HomeFragmentAdapter
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private lateinit var adapter: HomeFragmentAdapter
    private lateinit var recyclerView: RecyclerView
    companion object {
        private val TAG = this::class.simpleName
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView = homeRecyclerView
        recyclerView.layoutManager = layoutManager

        viewModel.homeAdapterData.observe(viewLifecycleOwner, Observer {
            it.let {
                Log.d(TAG, if(it.isNullOrEmpty()) "Empty List" else "$it")
                adapter = HomeFragmentAdapter(activity?.applicationContext!!, it)
                recyclerView.adapter = adapter
           }
        })
    }

}
