package com.example.joaop.slide

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup



class SlideAdapter (fragmentManager: FragmentManager):
FragmentStatePagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment {
        return SlideFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return 4
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)

    }
}