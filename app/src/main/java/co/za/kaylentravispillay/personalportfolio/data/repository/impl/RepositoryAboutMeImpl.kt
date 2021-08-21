package co.za.kaylentravispillay.personalportfolio.data.repository.impl

import co.za.kaylentravispillay.personalportfolio.data.dto.DTOResult
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMe
import co.za.kaylentravispillay.personalportfolio.data.dto.mapToDTOResult
import co.za.kaylentravispillay.personalportfolio.data.repository.RepositoryAboutMe
import co.za.kaylentravispillay.personalportfolio.source.retrofit.SourceRetrofit

class RepositoryAboutMeImpl(
    private val sourceRetrofit: SourceRetrofit
) : RepositoryAboutMe {

    override suspend fun getAboutMe(): DTOResult<DTOAboutMe> {
        return try {
            sourceRetrofit.portfolioProviderService.getAboutMe("1").mapToDTOResult()
        } catch (exp: Exception) {
            DTOResult.Error(status = -1, message = String())
        }
    }
}