package co.za.kaylentravispillay.personalportfolio.source.retrofit.service

import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMe
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMeProfile
import co.za.kaylentravispillay.personalportfolio.source.retrofit.endpoint.SourceRetrofitEndpoint
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SourceRetrofitServicePortfolioProvider {

    @GET(SourceRetrofitEndpoint.ABOUT_ME)
    suspend fun getAboutMe(@Path("userId") userId: String): Response<DTOAboutMe>

    @GET(SourceRetrofitEndpoint.ABOUT_ME_PROFILE)
    suspend fun getAboutMeProfile(@Path("userId") userId: String): Response<DTOAboutMeProfile>
}