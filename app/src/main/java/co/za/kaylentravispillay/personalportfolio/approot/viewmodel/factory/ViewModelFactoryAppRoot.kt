package co.za.kaylentravispillay.personalportfolio.approot.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.za.kaylentravispillay.personalportfolio.approot.viewmodel.ViewModelAppRoot
import co.za.kaylentravispillay.personalportfolio.approot.viewmodel.impl.ViewModelAppRootImpl
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactoryAppRoot : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelAppRoot::class.java)) {
            return ViewModelAppRootImpl() as T
        }

        throw IllegalArgumentException("Unable to create ViewModelAppRoot")
    }
}