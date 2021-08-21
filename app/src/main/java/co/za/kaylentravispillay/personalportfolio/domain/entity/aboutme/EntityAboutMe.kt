package co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme

import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.section.EntityAboutMeSection

data class EntityAboutMe(
    val profile: EntityAboutMeProfile,
    val sections: List<EntityAboutMeSection>
)