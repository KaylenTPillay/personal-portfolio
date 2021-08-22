package co.za.kaylentravispillay.personalportfolio.ui.aboutme.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseAboutMeGet
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model.UIModelAboutMeItem
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model.mapping.mapToAboutMeItems
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.viewmodel.ViewModelAboutMe
import co.za.kaylentravispillay.personalportfolio.ui.util.event.SingleLiveEvent
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar
import co.za.kaylentravispillay.personalportfolio.ui.util.taptoretry.model.UIModelTapToRetry
import kotlinx.coroutines.launch

class ViewModelAboutMeImpl(
    private val useCaseAboutMeGet: UseCaseAboutMeGet
) : ViewModelAboutMe, ViewModel() {

    private var hasInitialised: Boolean = false
    private var isInErrorState: Boolean = false

    private var currentErrorMessage: String = String()

    private val screenTitle = UIModelToolbar(title = "About Me")

    private val mToolbarObservable: MutableLiveData<UIModelToolbar> = MutableLiveData()
    override val toolbarObservable: LiveData<UIModelToolbar> = mToolbarObservable

    private val mContentObservable: MutableLiveData<List<UIModelAboutMeItem>> = MutableLiveData()
    override val contentObservable: LiveData<List<UIModelAboutMeItem>> = mContentObservable

    private val mTapToRetryObservable: SingleLiveEvent<UIModelTapToRetry> = SingleLiveEvent()
    override val tapToRetryObservable: LiveData<UIModelTapToRetry> = mTapToRetryObservable

    override fun init() {
        mToolbarObservable.value = screenTitle

        when {
            !hasInitialised -> getData()
            isInErrorState -> handleErrorState(currentErrorMessage)
        }
    }

    override fun onTapToRetryClick() {
        isInErrorState = false
        currentErrorMessage = String()

        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            hasInitialised = when (val result = useCaseAboutMeGet.getAboutMeData()) {
                is EntityResult.Success -> {
                    mContentObservable.value = result.response.mapToAboutMeItems()
                    true
                }
                is EntityResult.Error -> {
                    handleErrorState(result.message)
                    true
                }
            }
        }
    }

    private fun handleErrorState(message: String) {
        isInErrorState = true
        currentErrorMessage = message

        mTapToRetryObservable.value = UIModelTapToRetry(message = message)
    }
}