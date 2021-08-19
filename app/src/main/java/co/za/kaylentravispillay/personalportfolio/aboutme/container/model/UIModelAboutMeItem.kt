package co.za.kaylentravispillay.personalportfolio.aboutme.container.model

import android.graphics.Rect
import co.za.kaylentravispillay.personalportfolio.util.itemdecoration.spaceaware.model.UIModelSpaceAware
import co.za.kaylentravispillay.personalportfolio.util.resourcedimension.ResourceDimension

sealed interface UIModelAboutMeItem : UIModelSpaceAware {
    val id: String

    override fun getSpaceAwareRect(
        position: Int,
        nextItemType: Int?,
        previousItemType: Int?,
        isLastItem: Boolean
    ): Rect {
        val topMargin = if (position == 0) {
            ResourceDimension.getDimensions().dimen8
        } else {
            ResourceDimension.getDimensions().dimen2
        }
        val bottomMargin = if (isLastItem) {
            ResourceDimension.getDimensions().dimen8
        } else {
            0
        }
        val startAndEndMargin = ResourceDimension.getDimensions().dimen16
        return Rect(startAndEndMargin, topMargin, startAndEndMargin, bottomMargin)
    }
}