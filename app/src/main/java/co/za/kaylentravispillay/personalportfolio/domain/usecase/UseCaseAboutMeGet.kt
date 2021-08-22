package co.za.kaylentravispillay.personalportfolio.domain.usecase

import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.EntityAboutMe

interface UseCaseAboutMeGet {
    suspend fun getAboutMeData(): EntityResult<EntityAboutMe>
}