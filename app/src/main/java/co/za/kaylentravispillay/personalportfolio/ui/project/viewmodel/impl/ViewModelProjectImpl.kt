package co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.ViewModelProject
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar

class ViewModelProjectImpl : ViewModel(), ViewModelProject {

    private val screenTitle = UIModelToolbar("Projects")

    private val mToolbarObservable: MutableLiveData<UIModelToolbar> = MutableLiveData()
    override val toolbarObservable: LiveData<UIModelToolbar> = mToolbarObservable

    override fun init() {
        mToolbarObservable.value = screenTitle
    }
}