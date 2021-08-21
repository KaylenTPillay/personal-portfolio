package co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.maxwidth

import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.za.kaylentravispillay.personalportfolio.ui.util.extension.getUsableDisplayDimensions
import co.za.kaylentravispillay.personalportfolio.ui.util.resourcedimension.ResourceDimension

class ItemDecorationMaxWidth : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val margin = getApplicableStartAndEndMargin(view.context)

        outRect.left = margin
        outRect.right = margin
    }

    companion object {
        private var currentDisplayDimension = Point()
        private var currentCachedApplicableMargin = 0

        private fun getApplicableStartAndEndMargin(context: Context): Int {
            val displayDimension = context.getUsableDisplayDimensions()

            if (currentDisplayDimension != displayDimension) {
                currentDisplayDimension = displayDimension
                val availableMarginSpace = displayDimension.x - ResourceDimension.getDimensions().dimen640

                currentCachedApplicableMargin = if (availableMarginSpace > 0) {
                    availableMarginSpace / 2
                } else {
                    0
                }
            }

            return currentCachedApplicableMargin
        }
    }
}