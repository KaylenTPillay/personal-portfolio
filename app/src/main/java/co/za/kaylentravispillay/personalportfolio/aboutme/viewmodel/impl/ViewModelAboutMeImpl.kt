package co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel.ViewModelAboutMe
import co.za.kaylentravispillay.personalportfolio.util.model.UIModelToolbar

class ViewModelAboutMeImpl : ViewModelAboutMe, ViewModel() {

    private val screenTitle = UIModelToolbar(title = "About Me")

    private val mToolbarObservable: MutableLiveData<UIModelToolbar> = MutableLiveData()
    override val toolbarObservable: LiveData<UIModelToolbar> = mToolbarObservable

    override fun init() {
        mToolbarObservable.value = screenTitle
    }
}