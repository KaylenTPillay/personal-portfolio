package co.za.kaylentravispillay.personalportfolio.source.retrofit

import co.za.kaylentravispillay.personalportfolio.source.retrofit.service.SourceRetrofitServiceGithub
import co.za.kaylentravispillay.personalportfolio.source.retrofit.service.SourceRetrofitServicePortfolioProvider

interface SourceRetrofit {
    val portfolioProviderService: SourceRetrofitServicePortfolioProvider
    val githubService: SourceRetrofitServiceGithub
}