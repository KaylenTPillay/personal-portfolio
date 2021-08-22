package co.za.kaylentravispillay.personalportfolio.source.buildconfig.impl

import co.za.kaylentravispillay.personalportfolio.BuildConfig
import co.za.kaylentravispillay.personalportfolio.source.buildconfig.SourceBuildConfig

object SourceBuildConfigImpl : SourceBuildConfig {
    override val userId: String = BuildConfig.API_ID
}