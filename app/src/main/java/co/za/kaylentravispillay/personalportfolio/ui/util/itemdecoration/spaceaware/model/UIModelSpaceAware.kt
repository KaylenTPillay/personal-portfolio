package co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.model

import android.graphics.Rect

interface UIModelSpaceAware {
    fun getSpaceAwareRect(
        position: Int,
        nextItemType: Int?,
        previousItemType: Int?,
        isLastItem: Boolean
    ): Rect
}