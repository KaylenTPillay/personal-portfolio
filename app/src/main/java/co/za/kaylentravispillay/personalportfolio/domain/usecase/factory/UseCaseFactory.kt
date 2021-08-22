package co.za.kaylentravispillay.personalportfolio.domain.usecase.factory

import co.za.kaylentravispillay.personalportfolio.data.repository.factory.RepositoryFactory
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseAboutMeGet
import co.za.kaylentravispillay.personalportfolio.domain.usecase.impl.UseCaseAboutMeGetImpl

object UseCaseFactory {

    fun createAboutMeGet(): UseCaseAboutMeGet {
        return UseCaseAboutMeGetImpl(
            repositoryAboutMe = RepositoryFactory.createAboutMe()
        )
    }
}