package ru.bdim.lessons

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class ThemeActivity : AppCompatActivity() {

    companion object {
        private const val THEME = "theme"
    }
    private var themeNumber = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState?.let{
            themeNumber = it.getInt(THEME)
            when (themeNumber){
                1 -> setTheme(R.style.AppTheme)
                2 -> setTheme(R.style.AppThemePurple)
                3 -> setTheme(R.style.AppThemeBrown)
                4 -> setTheme(R.style.AppThemeYellow)
            }
        }
        setContentView(R.layout.activity_theme_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.theme_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        themeNumber = when (item.itemId){
            R.id.mnu_theme_green -> 1
            R.id.mnu_theme_purple -> 2
            R.id.mnu_theme_brown -> 3
            R.id.mnu_theme_yellow -> 4
            else -> 1
        }
        recreate()
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(THEME, themeNumber)
    }
}