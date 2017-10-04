package com.egci428.ex_listactivitymodel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_detail.*
import android.view.Menu
import java.text.NumberFormat


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val bundle = intent.extras

        val description: String
        val courseNo: String
        val credits: String

        description = descriptionText.text.toString()
        courseNo = courseNoText.text.toString()
        credits = creditsText.text.toString()

        button.setOnClickListener {
            finish()
        }
    }
}
