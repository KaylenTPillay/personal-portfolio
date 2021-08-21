package co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.section

data class EntityAboutMeParagraphSection(
    override val id: String,
    val paragraph: String
) : EntityAboutMeSection