package co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel

import androidx.lifecycle.LiveData
import co.za.kaylentravispillay.personalportfolio.util.model.UIModelToolbar

interface ViewModelAboutMe {
    val toolbarObservable: LiveData<UIModelToolbar>

    fun init()
}