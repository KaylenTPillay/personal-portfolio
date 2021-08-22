package co.za.kaylentravispillay.personalportfolio.ui.util.resourcedimension

import android.content.Context
import co.za.kaylentravispillay.personalportfolio.R

class CommonDimension(context: Context) {
    var dimen1: Int = 0
        private set
    var dimen2: Int = 0
        private set
    var dimen8: Int = 0
        private set
    var dimen16: Int = 0
        private set
    var dimen150: Int = 0
        private set
    var dimen640: Int = 0
        private set

    init {
        dimen1 = context.resources.getDimensionPixelSize(R.dimen.dimen1)
        dimen2 = context.resources.getDimensionPixelSize(R.dimen.dimen2)
        dimen8 = context.resources.getDimensionPixelSize(R.dimen.dimen8)
        dimen16 = context.resources.getDimensionPixelSize(R.dimen.dimen16)
        dimen150 = context.resources.getDimensionPixelSize(R.dimen.dimen150)
        dimen640 = context.resources.getDimensionPixelSize(R.dimen.dimen640)
    }
}