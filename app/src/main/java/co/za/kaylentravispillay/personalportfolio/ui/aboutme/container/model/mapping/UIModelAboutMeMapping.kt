package co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model.mapping

import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.EntityAboutMe
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.EntityAboutMeProfile
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.section.EntityAboutMeParagraphSection
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.section.EntityAboutMeSection
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.section.EntityAboutMeTitleSection
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model.UIModelAboutMeHeader
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model.UIModelAboutMeItem
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model.UIModelAboutMeParagraph
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model.UIModelAboutMeTitle

fun EntityAboutMe.mapToAboutMeItems(): List<UIModelAboutMeItem> {
    return this@mapToAboutMeItems.profile.mapToHeaderItem() +
            this@mapToAboutMeItems.sections.map { section -> section.mapToItem() }
}

private fun EntityAboutMeProfile.mapToHeaderItem(): List<UIModelAboutMeItem> {
    return listOf(
        UIModelAboutMeHeader(
            id = this@mapToHeaderItem.fullName,
            profileProfessionalTitle = this@mapToHeaderItem.careerTitle,
            profileName = this@mapToHeaderItem.fullName,
            profileThumbnail = this@mapToHeaderItem.thumbnail
        )
    )
}

private fun EntityAboutMeSection.mapToItem(): UIModelAboutMeItem {
    return when (this@mapToItem) {
        is EntityAboutMeTitleSection -> this@mapToItem.mapToTitleItem()
        is EntityAboutMeParagraphSection -> this@mapToItem.mapToParagraphItem()
    }
}

private fun EntityAboutMeTitleSection.mapToTitleItem(): UIModelAboutMeTitle {
    return UIModelAboutMeTitle(
        id = this@mapToTitleItem.id,
        text = this@mapToTitleItem.title
    )
}

private fun EntityAboutMeParagraphSection.mapToParagraphItem(): UIModelAboutMeParagraph {
    return UIModelAboutMeParagraph(
        id = this@mapToParagraphItem.id,
        text = this@mapToParagraphItem.paragraph
    )
}