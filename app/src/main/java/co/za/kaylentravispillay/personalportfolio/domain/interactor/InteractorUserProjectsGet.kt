package co.za.kaylentravispillay.personalportfolio.domain.interactor

import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.entity.project.EntityProject

interface InteractorUserProjectsGet {
    suspend fun getUserProjects(): EntityResult<List<EntityProject>>
}