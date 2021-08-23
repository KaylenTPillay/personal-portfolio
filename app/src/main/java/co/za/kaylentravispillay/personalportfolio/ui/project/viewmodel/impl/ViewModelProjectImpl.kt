package co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.UIModelProjectItem
import co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.ViewModelProject
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar

class ViewModelProjectImpl : ViewModel(), ViewModelProject {

    private val screenTitle = UIModelToolbar("Projects")

    private val mToolbarObservable: MutableLiveData<UIModelToolbar> = MutableLiveData()
    override val toolbarObservable: LiveData<UIModelToolbar> = mToolbarObservable

    private val mProjectItemObservable: MutableLiveData<List<UIModelProjectItem>> = MutableLiveData()
    override val projectItemObservable: LiveData<List<UIModelProjectItem>> = mProjectItemObservable

    override fun init() {
        mToolbarObservable.value = screenTitle
        mProjectItemObservable.value = List(15) {
            UIModelProjectItem(
                id = it.toString(),
                title = "Project Title $it",
                description = "Description $it",
                link = "Link $it",
                watchers = 3 * it,
                stars = 10 * it
            )
        }
    }

    override fun onGithubLinkClick(link: String) {

    }
}