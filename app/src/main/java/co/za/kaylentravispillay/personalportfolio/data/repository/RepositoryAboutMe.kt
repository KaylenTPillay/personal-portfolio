package co.za.kaylentravispillay.personalportfolio.data.repository

import co.za.kaylentravispillay.personalportfolio.data.dto.DTOResult
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMe

interface RepositoryAboutMe {
    suspend fun getAboutMe(): DTOResult<DTOAboutMe>
}