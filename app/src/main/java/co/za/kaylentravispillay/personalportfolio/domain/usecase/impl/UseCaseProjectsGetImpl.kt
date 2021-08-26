package co.za.kaylentravispillay.personalportfolio.domain.usecase.impl

import co.za.kaylentravispillay.personalportfolio.data.repository.RepositoryProjects
import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.entity.mapToEntityResult
import co.za.kaylentravispillay.personalportfolio.domain.entity.project.EntityProject
import co.za.kaylentravispillay.personalportfolio.domain.entity.project.mapping.mapToEntityProjects
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseProjectsGet

class UseCaseProjectsGetImpl(
    private val repositoryProjects: RepositoryProjects
) : UseCaseProjectsGet {

    override suspend fun getProjects(username: String): EntityResult<List<EntityProject>> {
        return repositoryProjects.getGithubPublicRepos(username).mapToEntityResult { dtos ->
            dtos.mapToEntityProjects()
        }
    }
}