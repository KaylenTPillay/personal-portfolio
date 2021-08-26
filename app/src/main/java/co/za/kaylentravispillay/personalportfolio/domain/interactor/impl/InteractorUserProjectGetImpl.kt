package co.za.kaylentravispillay.personalportfolio.domain.interactor.impl

import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.entity.project.EntityProject
import co.za.kaylentravispillay.personalportfolio.domain.interactor.InteractorUserProjectsGet
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseAboutMeProfileGet
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseProjectsGet

class InteractorUserProjectGetImpl(
    private val useCaseAboutMeProfileGet: UseCaseAboutMeProfileGet,
    private val useCaseProjectsGet: UseCaseProjectsGet
) : InteractorUserProjectsGet {

    override suspend fun getUserProjects(): EntityResult<List<EntityProject>> {
        return when (val profileResponse = useCaseAboutMeProfileGet.getAboutMeProfile()) {
            is EntityResult.Success -> {
                useCaseProjectsGet.getProjects(profileResponse.response.githubUsername)
            }
            is EntityResult.Error -> {
                EntityResult.Error(
                    status = profileResponse.status,
                    message = profileResponse.message
                )
            }
        }
    }
}