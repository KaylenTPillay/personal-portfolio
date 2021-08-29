package co.za.kaylentravispillay.personalportfolio.ui.document.viewmodel

import androidx.lifecycle.LiveData
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar

interface ViewModelDocument {
    val toolbarObservable: LiveData<UIModelToolbar>

    fun init()
}