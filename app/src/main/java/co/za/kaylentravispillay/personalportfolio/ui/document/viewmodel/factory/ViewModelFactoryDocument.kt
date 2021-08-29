package co.za.kaylentravispillay.personalportfolio.ui.document.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.za.kaylentravispillay.personalportfolio.ui.document.viewmodel.ViewModelDocument
import co.za.kaylentravispillay.personalportfolio.ui.document.viewmodel.impl.ViewModelDocumentImpl

@Suppress("unchecked_cast")
class ViewModelFactoryDocument : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelDocument::class.java)) {
            return ViewModelDocumentImpl() as T
        }

        throw IllegalStateException("Unable to create ViewModelDocument")
    }
}