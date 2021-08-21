package co.za.kaylentravispillay.personalportfolio.aboutme.container.model

import android.graphics.Rect
import co.za.kaylentravispillay.personalportfolio.util.itemdecoration.spaceaware.model.UIModelSpaceAware
import co.za.kaylentravispillay.personalportfolio.util.resourcedimension.ResourceDimension

data class UIModelAboutMeHeader(
    override val id: String,
    val profileThumbnail: String,
    val profileName: String,
    val profileProfessionalTitle: String
) : UIModelAboutMeItem, UIModelSpaceAware {

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