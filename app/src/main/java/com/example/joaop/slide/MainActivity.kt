package com.example.joaop.slide

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: SlideAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewPager = findViewById(R.id.vp)
//
//        pagerAdapter = SlideAdapter(supportFragmentManager)
//
//        viewPager.adapter = pagerAdapter
//        viewPager.addOnPageChangeListener(onPageChangeListener)
        chkState2.setOnClickListener { chkState.isChecked = false; chkState2.isChecked = true }
        chkState.setOnClickListener { chkState.isChecked = true; chkState2.isChecked = false ;
        }


    }
    private val onPageChangeListener = object : ViewPager.OnPageChangeListener {
        var currentPosition = 0
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            val fragmentToHide = pagerAdapter.getItem(currentPosition) as SlideFragment
            fragmentToHide.onPauseFragment()

            val fragmentToShow = pagerAdapter.getItem(position) as SlideFragment
            fragmentToShow.onResumeFragment()

            currentPosition = position
        }

        override fun onPageScrollStateChanged(state: Int) {
        }
    }

}
