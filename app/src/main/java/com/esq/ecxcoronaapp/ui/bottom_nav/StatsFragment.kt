package com.esq.ecxcoronaapp.ui.bottom_nav

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.esq.ecxcoronaapp.R

class StatsFragment : Fragment() {

    companion object {
        private val TAG = this::class.simpleName
        fun newInstance() = StatsFragment()
    }

    private lateinit var viewModel: StatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.stats_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StatsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
