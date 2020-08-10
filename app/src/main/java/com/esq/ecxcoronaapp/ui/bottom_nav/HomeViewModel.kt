package com.esq.ecxcoronaapp.ui.bottom_nav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esq.ecxcoronaapp.data.Repository
import com.esq.ecxcoronaapp.domain.model.HomeListModel

class HomeViewModel : ViewModel() {
    private val _homeAdapterData = MutableLiveData<List<HomeListModel>>().apply {
        value = Repository.homeInfo
    }

    val homeAdapterData: LiveData<List<HomeListModel>> = _homeAdapterData
}
