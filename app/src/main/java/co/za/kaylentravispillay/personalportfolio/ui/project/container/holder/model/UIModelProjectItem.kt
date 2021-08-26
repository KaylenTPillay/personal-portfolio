package co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model

import android.graphics.Rect
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.model.UIModelSpaceAware
import co.za.kaylentravispillay.personalportfolio.ui.util.resourcedimension.ResourceDimension

data class UIModelProjectItem(
    val id: String,
    val title: String,
    val description: String,
    val link: String,
    val isLoading: Boolean,
    private val watchers: Int,
    private val stars: Int
) : UIModelSpaceAware {

    val watchersDisplayText = "Watchers: $watchers"
    val starsDisplayText = "Stars: $stars"

    val isTitleActive: Boolean = title.isNotBlank()
    val isDescriptionActive: Boolean = description.isNotBlank()

    constructor(id: String, isLoading: Boolean): this(
        id = id,
        title = String(),
        description = String(),
        link = String(),
        watchers = 0,
        stars = 0,
        isLoading = isLoading
    )

    override fun getSpaceAwareRect(
        position: Int,
        nextItemType: Int?,
        previousItemType: Int?,
        isLastItem: Boolean
    ): Rect {
        val rect = Rect()

        rect.bottom = ResourceDimension.getDimensions().dimen2

        when {
            position == 0 -> rect.top = ResourceDimension.getDimensions().dimen8
            isLastItem -> rect.bottom = ResourceDimension.getDimensions().dimen16
        }

        return rect
    }
}