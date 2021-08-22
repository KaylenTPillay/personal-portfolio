package co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.adapter.AdapterSpaceAware

class ItemDecorationSpaceAware : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val adapter = parent.adapter as? AdapterSpaceAware ?: return super.getItemOffsets(
            outRect,
            view,
            parent,
            state
        )

        val itemCount = parent.adapter?.itemCount ?: state.itemCount
        val currentItemPosition = parent.getChildAdapterPosition(view)
        val isLastItem = currentItemPosition == itemCount - 1

        val (nextItemType, previousItemType) = getSurroundingItemTypes(
            currentItemPosition,
            itemCount,
            adapter
        )
        val modelForPosition = adapter.getSpaceAwareItemModelForPosition(currentItemPosition)
        if (modelForPosition != null) {
            outRect.set(
                modelForPosition.getSpaceAwareRect(
                    currentItemPosition,
                    nextItemType,
                    previousItemType,
                    isLastItem
                )
            )
        }
    }

    private fun getSurroundingItemTypes(
        currentPosition: Int,
        itemCount: Int,
        adapter: AdapterSpaceAware
    ): Pair<Int?, Int?> {
        val nextItemPosition = if (currentPosition + 1 >= itemCount) null else currentPosition + 1
        val previousItemPosition = if (currentPosition - 1 < 0) null else currentPosition - 1

        val nextItemType = adapter.getSpaceAwareItemTypeForPosition(nextItemPosition)
        val previousItemType = adapter.getSpaceAwareItemTypeForPosition(previousItemPosition)

        return Pair(nextItemType, previousItemType)
    }
}