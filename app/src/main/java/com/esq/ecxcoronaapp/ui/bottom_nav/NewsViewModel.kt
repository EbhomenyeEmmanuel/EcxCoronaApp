package com.esq.ecxcoronaapp.ui.bottom_nav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esq.ecxcoronaapp.data.Repository
import com.esq.ecxcoronaapp.domain.model.NewsListModel

class NewsViewModel : ViewModel() {
    private val _newsAdapterData = MutableLiveData<List<NewsListModel>>().apply {
    value = Repository.newsList
}

    val newsAdapterData: LiveData<List<NewsListModel>> = _newsAdapterData
}
