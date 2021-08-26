package co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.za.kaylentravispillay.personalportfolio.domain.interactor.factory.InteractorFactory
import co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.ViewModelProject
import co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.impl.ViewModelProjectImpl

@Suppress("unchecked_cast")
class ViewModelFactoryProject : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelProject::class.java)) {
            return ViewModelProjectImpl(
                interactorUserProjectsGet = InteractorFactory.createUserProjectsGet()
            ) as T
        }

        throw IllegalStateException("Unable to create ViewModelProject")
    }
}