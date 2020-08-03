package ru.bdim.lessons

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_progressbar.*
import kotlinx.coroutines.*

class ProgerssbarAvtivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progressbar)

        btn_circle_begin.setOnClickListener(this)
        btn_circle_finish.setOnClickListener(this)
        btn_line_start.setOnClickListener(this)
        btn_line_stop.setOnClickListener(this)

        prb_line.max = 100

    }

    override fun onClick(v: View?) {
        when (v) {
            btn_circle_begin -> prb_circle.visibility = View.VISIBLE
            btn_circle_finish -> prb_circle.visibility = View.INVISIBLE
            btn_line_start -> start()
            btn_line_stop -> stop()
        }
    }

    private fun start() {
        prb_line.visibility = View.VISIBLE
        if (prb_line.progress == 0){
            GlobalScope.launch {
                for (i: Int in 1..100) {
                    delay(100)
                    prb_line.progress = i
                }
            }
        }
    }
    private fun stop() {
        prb_line.visibility = View.INVISIBLE
        prb_line.progress = 0
    }

}