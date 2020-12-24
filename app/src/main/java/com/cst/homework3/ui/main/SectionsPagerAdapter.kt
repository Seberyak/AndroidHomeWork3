package com.cst.homework3.ui.main

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cst.homework3.CastFragment
import com.cst.homework3.DetailedMovieActivity
import com.cst.homework3.InfoFragment
import com.cst.homework3.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)


class SectionsPagerAdapter(private val context: DetailedMovieActivity, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = InfoFragment(context.movie);
            }
            1 -> {
                fragment = CastFragment(context.movie);

            }
        }
        return fragment!!;
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}