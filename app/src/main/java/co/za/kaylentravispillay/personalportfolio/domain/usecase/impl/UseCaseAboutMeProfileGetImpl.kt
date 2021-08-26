package co.za.kaylentravispillay.personalportfolio.domain.usecase.impl

import co.za.kaylentravispillay.personalportfolio.data.repository.RepositoryAboutMe
import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.EntityAboutMeProfile
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.mapping.mapToEntityProfile
import co.za.kaylentravispillay.personalportfolio.domain.entity.mapToEntityResult
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseAboutMeProfileGet

class UseCaseAboutMeProfileGetImpl(
    private val repositoryAboutMe: RepositoryAboutMe
) : UseCaseAboutMeProfileGet {

    override suspend fun getAboutMeProfile(): EntityResult<EntityAboutMeProfile> {
        return repositoryAboutMe.getAboutMeProfile().mapToEntityResult { dto ->
            dto.mapToEntityProfile()
        }
    }
}