package co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.mapping

import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMe
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMeSection
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMeSectionType
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.EntityAboutMe
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.EntityAboutMeProfile
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.section.EntityAboutMeParagraphSection
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.section.EntityAboutMeSection
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.section.EntityAboutMeTitleSection

fun DTOAboutMe.mapToEntity(): EntityAboutMe {
    return EntityAboutMe(
        profile = this@mapToEntity.mapToEntityProfile(),
        sections = this@mapToEntity.mapToEntitySections()
    )
}

private fun DTOAboutMe.mapToEntityProfile(): EntityAboutMeProfile {
    return EntityAboutMeProfile(
        fullName = this@mapToEntityProfile.profile.name,
        careerTitle = this@mapToEntityProfile.profile.title,
        thumbnail = this@mapToEntityProfile.profile.image
    )
}

private fun DTOAboutMe.mapToEntitySections(): List<EntityAboutMeSection> {
    return this@mapToEntitySections.sections.mapNotNull { dtoSection ->
        dtoSection.mapToEntitySection()
    }
}

private fun DTOAboutMeSection.mapToEntitySection(): EntityAboutMeSection? {
    return when (DTOAboutMeSectionType.fromString(this@mapToEntitySection.type)) {
        DTOAboutMeSectionType.TITLE -> this@mapToEntitySection.mapToEntityTitleSection()
        DTOAboutMeSectionType.PARAGRAPH -> this@mapToEntitySection.mapToEntityParagraphSection()
        DTOAboutMeSectionType.UNKNOWN -> null
    }
}

private fun DTOAboutMeSection.mapToEntityTitleSection(): EntityAboutMeTitleSection {
    return EntityAboutMeTitleSection(
        id = this@mapToEntityTitleSection.id,
        title = (this@mapToEntityTitleSection.value as? String) ?: String()
    )
}

private fun DTOAboutMeSection.mapToEntityParagraphSection(): EntityAboutMeParagraphSection {
    return EntityAboutMeParagraphSection(
        id = this@mapToEntityParagraphSection.id,
        paragraph = (this@mapToEntityParagraphSection.value as? String) ?: String()
    )
}