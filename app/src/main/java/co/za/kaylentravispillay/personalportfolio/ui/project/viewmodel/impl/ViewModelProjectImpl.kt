package co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.impl

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.interactor.InteractorUserProjectsGet
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.UIModelProjectItem
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.mapping.mapToUIModels
import co.za.kaylentravispillay.personalportfolio.ui.project.router.RouterProject
import co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.ViewModelProject
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar
import co.za.kaylentravispillay.personalportfolio.ui.util.taptoretry.model.UIModelTapToRetry
import kotlinx.coroutines.launch

class ViewModelProjectImpl(
    private val router: RouterProject,
    private val interactorUserProjectsGet: InteractorUserProjectsGet
) : ViewModel(), ViewModelProject {

    private var isInitialised: Boolean = false
    private var isInErrorState: Boolean = false

    private var currentErrorMessage: String = String()

    private val screenTitle = UIModelToolbar("Projects")
    private val loadingProjectModels = List(10) {
        UIModelProjectItem(id = it.toString(), isLoading = true)
    }

    private val mToolbarObservable: MutableLiveData<UIModelToolbar> = MutableLiveData()
    override val toolbarObservable: LiveData<UIModelToolbar> = mToolbarObservable

    private val mProjectItemObservable: MutableLiveData<List<UIModelProjectItem>> = MutableLiveData()
    override val projectItemObservable: LiveData<List<UIModelProjectItem>> = mProjectItemObservable

    private val mTapToRetryObservable: MutableLiveData<UIModelTapToRetry> = MutableLiveData()
    override val tapToRetryObservable: LiveData<UIModelTapToRetry> = mTapToRetryObservable

    private val mTapToRetryVisibilityObservable: MutableLiveData<Boolean> = MutableLiveData()
    override val tapToRetryVisibleObservable: LiveData<Boolean> = mTapToRetryVisibilityObservable

    override fun init() {
        mToolbarObservable.value = screenTitle

        when {
            !isInitialised -> getProjects()
            isInErrorState -> handleOnProjectError(currentErrorMessage)
        }
    }

    override fun onGithubLinkClick(context: Context, link: String) {
        router.routeToExternalLink(context, link)
    }

    override fun onTapToRetryClick() {
        isInErrorState = false
        mTapToRetryVisibilityObservable.value = false

        getProjects()
    }

    private fun getProjects() {
        mProjectItemObservable.value = loadingProjectModels
        viewModelScope.launch {
            isInitialised = when (val response = interactorUserProjectsGet.getUserProjects()) {
                is EntityResult.Success -> {
                    mProjectItemObservable.value = response.response.mapToUIModels()
                    true
                }
                is EntityResult.Error -> {
                    handleOnProjectError(response.message)
                    true
                }
            }
        }
    }

    private fun handleOnProjectError(message: String) {
        isInErrorState = true
        currentErrorMessage = message

        mProjectItemObservable.value = emptyList()
        mTapToRetryVisibilityObservable.value = true
        mTapToRetryObservable.value = UIModelTapToRetry(message)
    }
}