package ru.bdim.lessons
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val pictures = arrayListOf<Pic>(
            Pic(R.drawable.pic1, resources.getStringArray(R.array.title)[0]),
            Pic(R.drawable.pic2, resources.getStringArray(R.array.title)[1]),
            Pic(R.drawable.pic3, resources.getStringArray(R.array.title)[2])
        )

        val myAdapter = PictureRecyclerAdapter(pictures)
        with (rcvPictures){
            setHasFixedSize(true)
            adapter = myAdapter
            itemAnimator = DefaultItemAnimator()
        }
        ItemTouchHelper(ItemTouchHelperCallback(myAdapter))
            .attachToRecyclerView(rcvPictures)
    }
}

data class Pic(val pictureId: Int, val title: String)