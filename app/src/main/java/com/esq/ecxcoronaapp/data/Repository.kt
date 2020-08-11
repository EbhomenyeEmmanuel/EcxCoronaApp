package com.esq.ecxcoronaapp.data

import com.esq.ecxcoronaapp.R
import com.esq.ecxcoronaapp.domain.model.HomeListModel
import com.esq.ecxcoronaapp.domain.model.NewsListModel

class Repository() {

    companion object {
        val homeInfo = listOf(
            HomeListModel(
                R.drawable.card_chart,
                R.string.how_does_it_spread,
                R.string.learn_how_covid
            ),
            HomeListModel(
                R.drawable.card_symptoms,
                R.string.symptoms,
                R.string.learn_covid_19_symptoms
            ),
            HomeListModel(
                R.drawable.card_prevention,
                R.string.prevention_and_treatment,
                R.string.learn_how_to_prevent
            ),
            HomeListModel(
                R.drawable.card_what_to_do,
                R.string.what_to_do,
                R.string.learn_what_to_do
            )
        )

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
            )
        )
    }

}