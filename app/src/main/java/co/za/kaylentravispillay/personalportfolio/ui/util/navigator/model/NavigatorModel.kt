package co.za.kaylentravispillay.personalportfolio.ui.util.navigator.model

import android.net.Uri
import androidx.annotation.StringRes

sealed class NavigatorModel {
    data class URINavigatorModel(@StringRes val title: Int, val uri: Uri): NavigatorModel()
}