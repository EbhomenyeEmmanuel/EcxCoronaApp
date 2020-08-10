package com.esq.ecxcoronaapp.data

import com.esq.ecxcoronaapp.R
import com.esq.ecxcoronaapp.domain.model.HomeListModel

class Repository() {

    companion object {
        val homeInfo = listOf<HomeListModel>(
            HomeListModel(R.drawable.brain, "How does it spread?", "Learn how COVID-19 spread"),
            HomeListModel(R.drawable.fever_symptoms, "Symptoms", "Learn COVID-19 symptoms"),
            HomeListModel(R.drawable.prevent_card, "Prevention and Treatment", "Learn how to prevent COVID-19"),
            HomeListModel(R.drawable.brain, "What to do", "Learn what to do about COVID-19")
        )
    }
}