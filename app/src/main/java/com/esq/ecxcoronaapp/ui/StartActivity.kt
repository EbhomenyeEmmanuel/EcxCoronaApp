package com.esq.ecxcoronaapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.esq.ecxcoronaapp.MainActivity
import com.esq.ecxcoronaapp.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        arrow.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
