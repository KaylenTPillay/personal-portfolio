package co.za.kaylentravispillay.personalportfolio.ui.util.extension

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowInsets
import android.view.WindowManager
import androidx.annotation.RequiresApi

fun Context.getUsableDisplayDimensions(): Point {
    return when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> getMetricsForAPI30(this)
        else -> getMetricsForLegacy(this)
    }
}

@Suppress("DEPRECATION")
private fun getMetricsForLegacy(context: Context): Point {
    val displayMetrics = DisplayMetrics()
    val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as? WindowManager ?: return Point()

    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return Point(
        displayMetrics.widthPixels,
        displayMetrics.heightPixels
    )
}

@RequiresApi(Build.VERSION_CODES.R)
private fun getMetricsForAPI30(context: Context): Point {
    val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as? WindowManager ?: return Point()

    val windowMetric = windowManager.currentWindowMetrics
    val windowInsets = windowMetric.windowInsets
    val insets = windowInsets.getInsetsIgnoringVisibility(
        WindowInsets.Type.navigationBars() or WindowInsets.Type.displayCutout()
    )

    val insetWidth = insets.right + insets.left
    val insetHeight = insets.top + insets.bottom

    val bounds = windowMetric.bounds

    return Point(
        bounds.width() - insetWidth,
        bounds.height() - insetHeight
    )
}