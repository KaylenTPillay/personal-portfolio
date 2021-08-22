package co.za.kaylentravispillay.personalportfolio

import android.app.Application
import co.za.kaylentravispillay.personalportfolio.ui.util.resourcedimension.ResourceDimension

@Suppress("unused")
class PersonalPortfolioApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ResourceDimension.initialise(this)
    }
}