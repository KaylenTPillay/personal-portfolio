package co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.interactor.InteractorUserProjectsGet
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.UIModelProjectItem
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.mapping.mapToUIModels
import co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.ViewModelProject
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar
import kotlinx.coroutines.launch

class ViewModelProjectImpl(
    private val interactorUserProjectsGet: InteractorUserProjectsGet
) : ViewModel(), ViewModelProject {

    private var isInitialised: Boolean = false

    private val screenTitle = UIModelToolbar("Projects")

    private val mToolbarObservable: MutableLiveData<UIModelToolbar> = MutableLiveData()
    override val toolbarObservable: LiveData<UIModelToolbar> = mToolbarObservable

    private val mProjectItemObservable: MutableLiveData<List<UIModelProjectItem>> = MutableLiveData()
    override val projectItemObservable: LiveData<List<UIModelProjectItem>> = mProjectItemObservable

    override fun init() {
        mToolbarObservable.value = screenTitle

        when {
            !isInitialised -> getProjects()
        }
    }

    override fun onGithubLinkClick(link: String) {

    }

    private fun getProjects() {
        viewModelScope.launch {
            isInitialised = when (val response = interactorUserProjectsGet.getUserProjects()) {
                is EntityResult.Success -> {
                    mProjectItemObservable.value = response.response.mapToUIModels()
                    true
                }
                is EntityResult.Error -> {
                    mToolbarObservable.value = UIModelToolbar(response.status.toString())
                    true
                }
            }
        }
    }
}