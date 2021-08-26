package co.za.kaylentravispillay.personalportfolio.ui.util.navigator

import android.content.Context
import co.za.kaylentravispillay.personalportfolio.ui.util.navigator.model.NavigatorModel

interface Navigator {
    fun navigate(context: Context, model: NavigatorModel)
}