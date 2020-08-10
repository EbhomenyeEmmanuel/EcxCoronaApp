package com.esq.ecxcoronaapp.ui.navigation_drawer.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esq.ecxcoronaapp.data.Repository
import com.esq.ecxcoronaapp.domain.model.HomeListModel

class HomeViewModel() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    private val _homeAdapterData = MutableLiveData<List<HomeListModel>>().apply {
        value = Repository.homeInfo
    }

    val homeAdapterData: LiveData<List<HomeListModel>> = _homeAdapterData
}