package co.za.kaylentravispillay.personalportfolio.data.repository

import co.za.kaylentravispillay.personalportfolio.data.dto.DTOResult
import co.za.kaylentravispillay.personalportfolio.data.dto.project.DTOProject

interface RepositoryProjects {
    suspend fun getGithubPublicRepos(username: String): DTOResult<List<DTOProject>>
}