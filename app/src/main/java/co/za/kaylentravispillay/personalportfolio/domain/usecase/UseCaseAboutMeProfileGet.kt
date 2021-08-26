package co.za.kaylentravispillay.personalportfolio.domain.usecase

import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.EntityAboutMeProfile

interface UseCaseAboutMeProfileGet {
    suspend fun getAboutMeProfile(): EntityResult<EntityAboutMeProfile>
}