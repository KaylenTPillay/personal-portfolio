package co.za.kaylentravispillay.personalportfolio.ui.document.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.kaylentravispillay.personalportfolio.ui.document.viewmodel.ViewModelDocument
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar

class ViewModelDocumentImpl : ViewModel(), ViewModelDocument {

    private val screenTitle = UIModelToolbar(title = "Documents")

    private val mToolbarObservable: MutableLiveData<UIModelToolbar> = MutableLiveData()
    override val toolbarObservable: LiveData<UIModelToolbar> = mToolbarObservable

    override fun init() {
        mToolbarObservable.value = screenTitle
    }

}