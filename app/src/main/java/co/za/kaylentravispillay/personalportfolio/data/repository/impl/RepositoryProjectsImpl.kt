package co.za.kaylentravispillay.personalportfolio.data.repository.impl

import co.za.kaylentravispillay.personalportfolio.data.dto.DTOResult
import co.za.kaylentravispillay.personalportfolio.data.dto.mapToDTOResult
import co.za.kaylentravispillay.personalportfolio.data.dto.project.DTOProject
import co.za.kaylentravispillay.personalportfolio.data.repository.RepositoryProjects
import co.za.kaylentravispillay.personalportfolio.source.retrofit.SourceRetrofit
import co.za.kaylentravispillay.personalportfolio.source.retrofit.endpoint.SourceRetrofitEndpoint
import java.lang.Exception

class RepositoryProjectsImpl(
    private val sourceRetrofit: SourceRetrofit
) : RepositoryProjects {

    override suspend fun getGithubPublicRepos(username: String): DTOResult<List<DTOProject>> {
        return try {
            val headers = mapOf("Accept" to "application/vnd.github.v3+json")
            sourceRetrofit.githubService.getUserRepos(
                url = SourceRetrofitEndpoint.GITHUB_USER_REPOSITORIES.replace(
                    "{username}",
                    username
                ),
                headers = headers
            ).mapToDTOResult()
        } catch (exc: Exception) {
            DTOResult.Error(-1, "")
        }
    }
}