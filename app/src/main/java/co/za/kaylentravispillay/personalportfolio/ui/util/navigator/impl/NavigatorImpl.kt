package co.za.kaylentravispillay.personalportfolio.ui.util.navigator.impl

import android.content.Context
import android.content.Intent
import co.za.kaylentravispillay.personalportfolio.ui.util.navigator.Navigator
import co.za.kaylentravispillay.personalportfolio.ui.util.navigator.model.NavigatorModel

class NavigatorImpl : Navigator {

    override fun navigate(context: Context, model: NavigatorModel) {
        when (model) {
            is NavigatorModel.URINavigatorModel -> handleLinkNavigation(context, model)
        }
    }

    private fun handleLinkNavigation(context: Context, model: NavigatorModel.URINavigatorModel) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = model.uri
        }
        val chooserTitle = context.getString(model.title)
        val chooserIntent = Intent.createChooser(intent, chooserTitle)
        context.startActivity(chooserIntent)
    }
}