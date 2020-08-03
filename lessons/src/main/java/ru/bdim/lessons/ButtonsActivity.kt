package ru.bdim.lessons

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_buttons.*

class ButtonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)

        btn_flat.setOnClickListener(buttonListener)
        btn_bordered.setOnClickListener(buttonListener)
        btn_raised.setOnClickListener(buttonListener)
        btn_fab.setOnClickListener(buttonListener)

        tgr_buttons.addOnButtonCheckedListener { toggleGroup, button, isChecked ->
            btn_fab.size =
                when (button){
                    btn_plus.id -> if (isChecked) {
                        FloatingActionButton.SIZE_NORMAL
                    } else {
                        FloatingActionButton.SIZE_MINI
                    }
                    btn_minus.id -> if (!isChecked) {
                        FloatingActionButton.SIZE_NORMAL
                    } else {
                        FloatingActionButton.SIZE_MINI
                    }
                    else -> FloatingActionButton.INVISIBLE
                }
        }
    }
    private val buttonListener =  View.OnClickListener{
        when (it){
            btn_flat -> showMessage("Text")
            btn_bordered -> showMessage("OutLined")
            btn_raised -> showMessage("Raised")
            btn_fab -> showMessage("Floating Action")
        }
    }
    private fun showMessage(msg: String){
        Snackbar.make(btn_flat, "$msg Button pressed", Snackbar.LENGTH_LONG).show()
    }
}