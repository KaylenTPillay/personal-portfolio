package co.za.kaylentravispillay.personalportfolio.util.resourcedimension

import android.content.Context

object ResourceDimension {
    private lateinit var dimensions: CommonDimension

    fun initialise(context: Context) {
        if (!this::dimensions.isInitialized) {
            dimensions = CommonDimension(context)
        }
    }

    fun getDimensions(): CommonDimension {
        if (!this::dimensions.isInitialized) {
            throw IllegalStateException("ResourceDimension needs to be initialised before calling this method")
        }

        return dimensions
    }
}