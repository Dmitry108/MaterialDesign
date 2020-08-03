package ru.bdim.lessons

import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.drawer_appbar.*

class NavigationDriverActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        setSupportActionBar(tlb_drawer)
        val toggle = ActionBarDrawerToggle(this, dlt_drawer, tlb_drawer,
            R.string.open, R.string.close)
        dlt_drawer.addDrawerListener(toggle)
        toggle.syncState()

        val drawerListener =
            NavigationView.OnNavigationItemSelectedListener{
                when (it.itemId) {
                    R.id.mnu_walk -> setImage(R.drawable.ic_directions_walk_black_24dp)
                    R.id.mnu_bike -> setImage(R.drawable.ic_directions_bike_black_24dp)
                    R.id.mnu_motorcycle -> setImage(R.drawable.ic_motorcycle_black_24dp)
                    R.id.mnu_car -> setImage(R.drawable.ic_directions_car_black_24dp)
                    R.id.mnu_bus -> setImage(R.drawable.ic_directions_bus_black_24dp)
                    R.id.mnu_train -> setImage(R.drawable.ic_directions_transit_black_24dp)
                    R.id.mnu_plan -> setImage(R.drawable.ic_airplanemode_active_black_24dp)
                    R.id.mnu_boat -> setImage(R.drawable.ic_directions_boat_black_24dp)
                }
                dlt_drawer.closeDrawer(GravityCompat.START)
                return@OnNavigationItemSelectedListener true
            }
        nvw_drawer.setNavigationItemSelectedListener(drawerListener)
    }

    override fun onBackPressed() {
        if (dlt_drawer.isDrawerOpen(nvw_drawer)){
            dlt_drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun setImage(iconInt: Int){
        img_icon.setImageResource(iconInt)
    }
}