package co.za.kaylentravispillay.personalportfolio.util.itemdecoration.spaceaware.model

import android.graphics.Rect

interface UIModelSpaceAware {
    fun getSpaceAwareRect(
        position: Int,
        nextItemType: Int?,
        previousItemType: Int?,
        isLastItem: Boolean
    ): Rect
}