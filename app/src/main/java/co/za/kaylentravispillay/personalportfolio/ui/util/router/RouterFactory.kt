package co.za.kaylentravispillay.personalportfolio.ui.util.router

import co.za.kaylentravispillay.personalportfolio.ui.project.router.RouterProject
import co.za.kaylentravispillay.personalportfolio.ui.project.router.impl.RouterProjectImpl
import co.za.kaylentravispillay.personalportfolio.ui.util.navigator.impl.NavigatorImpl

object RouterFactory {

    fun createProjectRouter(): RouterProject {
        return RouterProjectImpl(NavigatorImpl())
    }
}