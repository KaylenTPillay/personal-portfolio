package co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel

import androidx.lifecycle.LiveData
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar

interface ViewModelProject {
    val toolbarObservable: LiveData<UIModelToolbar>

    fun init()
}