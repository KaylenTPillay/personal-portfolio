package co.za.kaylentravispillay.personalportfolio.domain.interactor.factory

import co.za.kaylentravispillay.personalportfolio.domain.interactor.InteractorUserProjectsGet
import co.za.kaylentravispillay.personalportfolio.domain.interactor.impl.InteractorUserProjectGetImpl
import co.za.kaylentravispillay.personalportfolio.domain.usecase.factory.UseCaseFactory

object InteractorFactory {

    fun createUserProjectsGet(): InteractorUserProjectsGet {
        return InteractorUserProjectGetImpl(
            useCaseAboutMeProfileGet = UseCaseFactory.createAboutMeProfileGet(),
            useCaseProjectsGet = UseCaseFactory.createProjectsGet()
        )
    }
}