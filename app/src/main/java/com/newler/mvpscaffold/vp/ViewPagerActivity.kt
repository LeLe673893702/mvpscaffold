package com.newler.mvpscaffold.vp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.newler.mvpscaffold.R
import com.newler.state.StateManager
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {
    private val tabTitles by lazy {
        mutableListOf<String>("1", "2", "3", "4", "5")
    }

    private val holder by lazy {
        StateManager.instance.wrap(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        holder?.showEmpty()
        holder?.showContent()
        vpState.adapter = TabPagAdapter(supportFragmentManager)

        tlState.setupWithViewPager(vpState)
    }


    inner class TabPagAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getItem(position: Int): Fragment = TestStateFragment.newInstance()

        override fun getCount(): Int  = tabTitles.size

        override fun getPageTitle(position: Int): CharSequence? {
            return tabTitles[position]
        }
    }

}
