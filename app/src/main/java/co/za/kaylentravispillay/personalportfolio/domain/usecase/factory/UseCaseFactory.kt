package co.za.kaylentravispillay.personalportfolio.domain.usecase.factory

import co.za.kaylentravispillay.personalportfolio.data.repository.factory.RepositoryFactory
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseAboutMeGet
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseAboutMeProfileGet
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseProjectsGet
import co.za.kaylentravispillay.personalportfolio.domain.usecase.impl.UseCaseAboutMeGetImpl
import co.za.kaylentravispillay.personalportfolio.domain.usecase.impl.UseCaseAboutMeProfileGetImpl
import co.za.kaylentravispillay.personalportfolio.domain.usecase.impl.UseCaseProjectsGetImpl

object UseCaseFactory {

    fun createAboutMeGet(): UseCaseAboutMeGet {
        return UseCaseAboutMeGetImpl(
            repositoryAboutMe = RepositoryFactory.createAboutMe()
        )
    }

    fun createProjectsGet(): UseCaseProjectsGet {
        return UseCaseProjectsGetImpl(
            repositoryProjects = RepositoryFactory.createProjects()
        )
    }

    fun createAboutMeProfileGet(): UseCaseAboutMeProfileGet {
        return UseCaseAboutMeProfileGetImpl(
            repositoryAboutMe = RepositoryFactory.createAboutMe()
        )
    }
}