package co.za.kaylentravispillay.personalportfolio.data.repository

import co.za.kaylentravispillay.personalportfolio.data.dto.DTOResult
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMe
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMeProfile

interface RepositoryAboutMe {
    suspend fun getAboutMe(): DTOResult<DTOAboutMe>

    suspend fun getAboutMeProfile(): DTOResult<DTOAboutMeProfile>
}