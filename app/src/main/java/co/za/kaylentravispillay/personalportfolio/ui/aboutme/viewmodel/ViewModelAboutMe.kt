package co.za.kaylentravispillay.personalportfolio.ui.aboutme.viewmodel

import androidx.lifecycle.LiveData
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model.UIModelAboutMeItem
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar
import co.za.kaylentravispillay.personalportfolio.ui.util.taptoretry.model.UIModelTapToRetry

interface ViewModelAboutMe {
    val toolbarObservable: LiveData<UIModelToolbar>
    val contentObservable: LiveData<List<UIModelAboutMeItem>>
    val tapToRetryObservable: LiveData<UIModelTapToRetry>

    fun init()

    fun onTapToRetryClick()
}