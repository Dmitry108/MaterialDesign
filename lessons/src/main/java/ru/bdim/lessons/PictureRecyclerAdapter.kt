package ru.bdim.lessons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recycler.view.*

class PictureRecyclerAdapter(private val pictures: MutableList<Pic>) :
    RecyclerView.Adapter<PictureRecyclerAdapter.PictureViewHolder>(), ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(pictures[position].pictureId, pictures[position].title)
    }

    override fun getItemCount(): Int {
        return pictures.size
    }
    override fun onItemDismiss(position: Int) {
        pictures.removeAt(position)
        notifyItemRemoved(position)
    }
    inner class PictureViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(picture: Int, title: String) = with(containerView) {
            imgRecycler.setImageDrawable(itemView.context.getDrawable(picture))
            txtRecycler.text = title
        }
    }
}

interface ItemTouchHelperAdapter {
    fun onItemDismiss(position: Int)
}

class ItemTouchHelperCallback(private val adapter: PictureRecyclerAdapter) :
    ItemTouchHelper.Callback() {

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags, swipeFlags)
    }
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return true
    }
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.onItemDismiss(viewHolder.adapterPosition)
    }
}