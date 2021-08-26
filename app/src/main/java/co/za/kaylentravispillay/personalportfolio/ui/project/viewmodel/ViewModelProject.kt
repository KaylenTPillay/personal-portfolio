package co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.UIModelProjectItem
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar
import co.za.kaylentravispillay.personalportfolio.ui.util.taptoretry.model.UIModelTapToRetry

interface ViewModelProject {
    val toolbarObservable: LiveData<UIModelToolbar>
    val projectItemObservable: LiveData<List<UIModelProjectItem>>
    val tapToRetryObservable: LiveData<UIModelTapToRetry>
    val tapToRetryVisibleObservable: LiveData<Boolean>

    fun init()

    fun onGithubLinkClick(context: Context, link: String)

    fun onTapToRetryClick()
}