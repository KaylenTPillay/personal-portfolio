package co.za.kaylentravispillay.personalportfolio.source.retrofit.service

import co.za.kaylentravispillay.personalportfolio.data.dto.project.DTOProject
import retrofit2.Response
import retrofit2.http.*

interface SourceRetrofitServiceGithub {

    @GET
    suspend fun getUserRepos(
        @Url url: String,
        @HeaderMap headers: Map<String, String>
    ): Response<List<DTOProject>>
}