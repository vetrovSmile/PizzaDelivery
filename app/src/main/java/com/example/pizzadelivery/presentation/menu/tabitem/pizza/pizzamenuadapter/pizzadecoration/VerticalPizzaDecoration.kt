package com.example.pizzadelivery.presentation.menu.tabitem.pizza.pizzamenuadapter.pizzadecoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalPizzaDecoration(
    private val space: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = space
        }

        outRect.bottom = space
        outRect.top = space

    }

}