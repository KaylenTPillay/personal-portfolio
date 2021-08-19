package co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel

import androidx.lifecycle.LiveData
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeItem
import co.za.kaylentravispillay.personalportfolio.util.model.UIModelToolbar

interface ViewModelAboutMe {
    val toolbarObservable: LiveData<UIModelToolbar>
    val contentObservable: LiveData<List<UIModelAboutMeItem>>

    fun init()
}