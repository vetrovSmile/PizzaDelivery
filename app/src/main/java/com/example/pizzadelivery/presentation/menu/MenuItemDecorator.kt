package com.example.pizzadelivery.presentation.menu

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MenuItemDecorator(
    private val spaceVertical: Int,
    private val spaceHorizontal: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        with(outRect) {

            if (parent.getChildAdapterPosition(view) == 0) {
                left = spaceHorizontal
            }
            right = spaceHorizontal
            top = spaceVertical
            bottom = spaceVertical
        }

    }
}