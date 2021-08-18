package co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel.ViewModelAboutMe
import co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel.impl.ViewModelAboutMeImpl
import java.lang.IllegalStateException

@Suppress("unchecked_cast")
class ViewModelFactoryAboutMe : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelAboutMe::class.java)) {
            return ViewModelAboutMeImpl() as T
        }

        throw IllegalStateException("Unable to create ViewModelAboutMe")
    }
}