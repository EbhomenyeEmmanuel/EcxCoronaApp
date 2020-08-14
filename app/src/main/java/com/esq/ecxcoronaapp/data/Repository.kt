package com.esq.ecxcoronaapp.data

import com.esq.ecxcoronaapp.R
import com.esq.ecxcoronaapp.domain.model.NewsListModel

class Repository() {
    companion object {
        val newsList = listOf(
            NewsListModel(
                R.drawable.news_images1,
                R.string.dummy_text
            ),
            NewsListModel(
                R.drawable.news_images2,
                R.string.dummy_text
            ),
            NewsListModel(
                R.drawable.news_images3,
                R.string.dummy_text
            ),
            NewsListModel(
                R.drawable.news_images4,
                R.string.dummy_text
            ),
            NewsListModel(
                R.drawable.news_images5,
                R.string.dummy_text
            ), NewsListModel(
                R.drawable.news_images3,
                R.string.dummy_text
            ), NewsListModel(
                R.drawable.news_images3,
                R.string.dummy_text
            ), NewsListModel(
                R.drawable.news_images1,
                R.string.dummy_text
            )
        )
    }
}