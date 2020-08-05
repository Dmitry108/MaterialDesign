package ru.bdim.lessons

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabBehavior (val context: Context, val attributeSet: AttributeSet): FloatingActionButton.Behavior(){

    init {
        FloatingActionButton.Behavior()
    }
    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        super.onNestedScroll(coordinatorLayout, child, target,
            dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed,
            type, consumed
        )
        if (dyConsumed > 0){
            val layoutParams = child.layoutParams as CoordinatorLayout.LayoutParams
            val fabBottomMargin = layoutParams.bottomMargin
            val fabEndMargin = layoutParams.marginEnd
            child.animate()
                .translationY((child.height + fabBottomMargin).toFloat())
                .translationX((child.width + fabEndMargin).toFloat())
                .setInterpolator(LinearInterpolator())
                .start()
        } else if (dyConsumed < 0){
            child.animate()
                .translationY(0f)
                .translationX(0f)
                .setInterpolator(LinearInterpolator()).start()
        }
    }

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }
}