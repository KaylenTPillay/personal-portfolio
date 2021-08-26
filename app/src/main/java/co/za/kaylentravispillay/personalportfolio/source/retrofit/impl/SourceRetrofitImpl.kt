package co.za.kaylentravispillay.personalportfolio.source.retrofit.impl

import co.za.kaylentravispillay.personalportfolio.source.retrofit.SourceRetrofit
import co.za.kaylentravispillay.personalportfolio.source.retrofit.endpoint.SourceRetrofitEndpoint
import co.za.kaylentravispillay.personalportfolio.source.retrofit.service.SourceRetrofitServiceGithub
import co.za.kaylentravispillay.personalportfolio.source.retrofit.service.SourceRetrofitServicePortfolioProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SourceRetrofitImpl : SourceRetrofit {

    private val client: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(SourceRetrofitEndpoint.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override val portfolioProviderService: SourceRetrofitServicePortfolioProvider =
        client.create(SourceRetrofitServicePortfolioProvider::class.java)

    override val githubService: SourceRetrofitServiceGithub =
        client.create(SourceRetrofitServiceGithub::class.java)
}