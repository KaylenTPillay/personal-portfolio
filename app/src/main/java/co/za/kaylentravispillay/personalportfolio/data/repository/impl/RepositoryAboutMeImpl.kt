package co.za.kaylentravispillay.personalportfolio.data.repository.impl

import co.za.kaylentravispillay.personalportfolio.data.dto.DTOResult
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMe
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMeProfile
import co.za.kaylentravispillay.personalportfolio.data.dto.mapToDTOResult
import co.za.kaylentravispillay.personalportfolio.data.repository.RepositoryAboutMe
import co.za.kaylentravispillay.personalportfolio.source.buildconfig.SourceBuildConfig
import co.za.kaylentravispillay.personalportfolio.source.retrofit.SourceRetrofit

class RepositoryAboutMeImpl(
    private val sourceRetrofit: SourceRetrofit,
    private val sourceBuildConfig: SourceBuildConfig
) : RepositoryAboutMe {

    override suspend fun getAboutMe(): DTOResult<DTOAboutMe> {
        return try {
            sourceRetrofit.portfolioProviderService.getAboutMe(
                sourceBuildConfig.userId
            ).mapToDTOResult()
        } catch (exp: Exception) {
            DTOResult.Error(status = -1, message = String())
        }
    }

    override suspend fun getAboutMeProfile(): DTOResult<DTOAboutMeProfile> {
        return try {
            sourceRetrofit.portfolioProviderService.getAboutMeProfile(
                sourceBuildConfig.userId
            ).mapToDTOResult()
        } catch (exp: Exception) {
            DTOResult.Error(status = -1, message = String())
        }
    }
}