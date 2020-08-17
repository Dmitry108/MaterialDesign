package ru.bdim.lessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigator.*

class BottomNavigationActivity : AppCompatActivity(){

    private val fragment1 = TabFragment.getInstance(R.drawable.ic_directions_walk_black_24dp)
    private val fragment2 = TabFragment.getInstance(R.drawable.ic_directions_car_black_24dp)
    private val fragment3 = TabFragment.getInstance(R.drawable.ic_directions_bus_black_24dp)

    private val navigationListener = BottomNavigationView.OnNavigationItemSelectedListener{
        return@OnNavigationItemSelectedListener when(it.itemId){
            R.id.bmn_walk -> {
                replaceFragment(fragment1)
                true }
            R.id.bmn_car -> {
                replaceFragment(fragment2)
                true }
            R.id.bmn_bus -> {
                replaceFragment(fragment3)
                true }
            else -> false
        }}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigator)

        replaceFragment(fragment1)
        bnvBottomNav.setOnNavigationItemSelectedListener(navigationListener)
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction().replace(R.id.flt_bottom_nav, fragment)
            .commit()
    }
}