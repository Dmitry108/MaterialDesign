package ru.bdim.lesson_2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_snackbar.*

class SnackbarActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        btn_snackbar.setOnClickListener{
            Snackbar.make(it, "Snackbar", Snackbar.LENGTH_LONG)
                .setAction("OK") { Log.d("...", "Snackbar") }
                .show()
        }
    }
}