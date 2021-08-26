package co.za.kaylentravispillay.personalportfolio.ui.project.router.impl

import android.content.Context
import android.net.Uri
import co.za.kaylentravispillay.personalportfolio.R
import co.za.kaylentravispillay.personalportfolio.ui.project.router.RouterProject
import co.za.kaylentravispillay.personalportfolio.ui.util.navigator.Navigator
import co.za.kaylentravispillay.personalportfolio.ui.util.navigator.model.NavigatorModel

class RouterProjectImpl(
    private val navigator: Navigator
) : RouterProject {

    override fun routeToExternalLink(context: Context, link: String) {
        val uri = Uri.parse(link)
        val navigatorModel = NavigatorModel.URINavigatorModel(
            title = R.string.project_github_chooser_title,
            uri = uri
        )
        navigator.navigate(context, navigatorModel)
    }
}