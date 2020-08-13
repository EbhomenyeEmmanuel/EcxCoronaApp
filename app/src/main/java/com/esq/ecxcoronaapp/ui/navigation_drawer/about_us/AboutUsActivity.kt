package com.esq.ecxcoronaapp.ui.navigation_drawer.about_us

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.esq.ecxcoronaapp.R
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element


class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val versionElement = Element()
        versionElement.title = "Version 1.0"
        val aboutPage: View = AboutPage(this).apply {
            isRTL(false)
            setImage(R.drawable.about_us_prevention)
            setDescription(resources.getString(R.string.description))
            addItem(versionElement)
            addGroup("Loren Ipsum")
            addEmail("lorenipsum@gmail.com")
        }.create()
        setContentView(aboutPage)
    }
}