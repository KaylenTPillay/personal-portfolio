package co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeHeader
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeItem
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeParagraph
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeTitle
import co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel.ViewModelAboutMe
import co.za.kaylentravispillay.personalportfolio.util.model.UIModelToolbar

class ViewModelAboutMeImpl : ViewModelAboutMe, ViewModel() {

    private val screenTitle = UIModelToolbar(title = "About Me")

    private val mToolbarObservable: MutableLiveData<UIModelToolbar> = MutableLiveData()
    override val toolbarObservable: LiveData<UIModelToolbar> = mToolbarObservable

    private val mContentObservable: MutableLiveData<List<UIModelAboutMeItem>> = MutableLiveData()
    override val contentObservable: LiveData<List<UIModelAboutMeItem>> = mContentObservable

    override fun init() {
        mToolbarObservable.value = screenTitle
        mContentObservable.value = List(5) {
            if (it == 0) {
                UIModelAboutMeHeader(
                    id = it.toString(),
                    profileThumbnail = "https://media-exp1.licdn.com/dms/image/C5603AQHAwsUCx_x6nQ/profile-displayphoto-shrink_200_200/0/1547707726993?e=1634169600&v=beta&t=XoYcm_yUgpOu14QyzWNUlmRP-YCIPcDdzKGxeqB9VnQ",
                    profileName = "Kaylen Travis Pillay",
                    profileProfessionalTitle = "Android Software Engineer"
                )
            } else if (it % 2 == 0) {
                UIModelAboutMeTitle(id = it.toString(), text = "Title $it")
            } else {
                UIModelAboutMeParagraph(
                    id = it.toString(),
                    text = """
                        This is a much longer piece of text and is used for a paragraph. $it
                    """.trimIndent()
                )
            }
        }
    }
}