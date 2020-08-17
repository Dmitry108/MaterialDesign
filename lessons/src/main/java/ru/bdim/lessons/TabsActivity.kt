package ru.bdim.lessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tabs.*

class TabsActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        setSupportActionBar(tlbTabs)

        val fragment1 = TabFragment.getInstance(R.drawable.ic_directions_walk_black_24dp)
        val fragment2 = TabFragment.getInstance(R.drawable.ic_directions_car_black_24dp)
        val fragment3 = TabFragment.getInstance(R.drawable.ic_directions_bus_black_24dp)

        val adapter = TabAdapter(supportFragmentManager)
        adapter.addFragment(fragment1, "Walk")
        adapter.addFragment(fragment2, "Car")
        adapter.addFragment(fragment3, "Bus")

        vpgTabs.adapter = adapter
        tltTabs.setupWithViewPager(vpgTabs)
    }
}