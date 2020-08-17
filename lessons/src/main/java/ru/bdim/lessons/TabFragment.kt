package ru.bdim.lessons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_tabs.view.*

class TabFragment : Fragment() {

    companion object {
        private const val IMAGE = "image"
        fun getInstance(image: Int): Fragment {
            val fragment: Fragment = TabFragment()
            val args = Bundle()
            args.putInt(IMAGE, image)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tabs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        bundle?.let {
            val image = it.getInt(IMAGE)
            view.imgFragment.setImageDrawable(resources.getDrawable(image, resources.newTheme()))
        }
    }
}