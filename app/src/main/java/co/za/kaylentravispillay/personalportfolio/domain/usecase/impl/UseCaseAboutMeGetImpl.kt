package co.za.kaylentravispillay.personalportfolio.domain.usecase.impl

import co.za.kaylentravispillay.personalportfolio.data.repository.RepositoryAboutMe
import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.EntityAboutMe
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.mapping.mapToEntity
import co.za.kaylentravispillay.personalportfolio.domain.entity.mapToEntityResult
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseAboutMeGet

class UseCaseAboutMeGetImpl(
    private val repositoryAboutMe: RepositoryAboutMe
) : UseCaseAboutMeGet {

    override suspend fun getAboutMeData(): EntityResult<EntityAboutMe> {
        return repositoryAboutMe.getAboutMe().mapToEntityResult { dto ->
            dto.mapToEntity()
        }
    }
}