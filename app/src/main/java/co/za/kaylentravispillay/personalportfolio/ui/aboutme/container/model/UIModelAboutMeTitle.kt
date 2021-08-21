package co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model

import android.graphics.Rect
import co.za.kaylentravispillay.personalportfolio.R
import co.za.kaylentravispillay.personalportfolio.util.itemdecoration.spaceaware.model.UIModelSpaceAware
import co.za.kaylentravispillay.personalportfolio.util.resourcedimension.ResourceDimension

data class UIModelAboutMeTitle(
    override val id: String,
    override val text: String
) : UIModelAboutMeText, UIModelSpaceAware {

    override val styleRes: Int = R.style.TextAppearance_MaterialComponents_Headline6

    override fun getSpaceAwareRect(
        position: Int,
        nextItemType: Int?,
        previousItemType: Int?,
        isLastItem: Boolean
    ): Rect {
        val rect = super.getSpaceAwareRect(position, nextItemType, previousItemType, isLastItem)

        rect.top = ResourceDimension.getDimensions().dimen16

        return rect
    }
}