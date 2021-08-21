package co.za.kaylentravispillay.personalportfolio.source.factory

import co.za.kaylentravispillay.personalportfolio.source.buildconfig.SourceBuildConfig
import co.za.kaylentravispillay.personalportfolio.source.buildconfig.impl.SourceBuildConfigImpl
import co.za.kaylentravispillay.personalportfolio.source.retrofit.SourceRetrofit
import co.za.kaylentravispillay.personalportfolio.source.retrofit.impl.SourceRetrofitImpl

object SourceFactory {

    fun createRetrofit(): SourceRetrofit {
        return SourceRetrofitImpl
    }

    fun createBuildConfig(): SourceBuildConfig {
        return SourceBuildConfigImpl
    }
}