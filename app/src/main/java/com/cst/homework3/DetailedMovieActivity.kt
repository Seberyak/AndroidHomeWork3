package com.cst.homework3

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity


import com.cst.homework3.ui.main.SectionsPagerAdapter
import java.lang.Error



class DetailedMovieActivity : AppCompatActivity() {

    lateinit var movie: HelperSchemas.IMovie

    override fun onCreate(savedInstanceState: Bundle?) {

        val movie = intent.getSerializableExtra("args") as HelperSchemas.IMovie
        this.movie = movie
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_movie)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }


}