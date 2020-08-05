package ru.bdim.lessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_collapsing.*

class CollapsingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing)

        setSupportActionBar(tlbCollapsingToolbar)

        btnCollapsingFab.setOnClickListener{
            Snackbar.make(it, "Гоголь \"Мертвые души\"", Snackbar.LENGTH_LONG).show()
        }
    }
}