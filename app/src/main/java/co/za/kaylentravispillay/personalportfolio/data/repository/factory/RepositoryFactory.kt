package co.za.kaylentravispillay.personalportfolio.data.repository.factory

import co.za.kaylentravispillay.personalportfolio.data.repository.RepositoryAboutMe
import co.za.kaylentravispillay.personalportfolio.data.repository.impl.RepositoryAboutMeImpl
import co.za.kaylentravispillay.personalportfolio.source.factory.SourceFactory

object RepositoryFactory {

    fun createAboutMe(): RepositoryAboutMe {
        return RepositoryAboutMeImpl(
            sourceRetrofit = SourceFactory.createRetrofit()
        )
    }
}