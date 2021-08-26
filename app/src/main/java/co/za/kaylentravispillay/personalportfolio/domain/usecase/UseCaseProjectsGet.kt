package co.za.kaylentravispillay.personalportfolio.domain.usecase

import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.entity.project.EntityProject

interface UseCaseProjectsGet {
    suspend fun getProjects(username: String): EntityResult<List<EntityProject>>
}