package co.za.kaylentravispillay.personalportfolio.ui.project.router

import android.content.Context

interface RouterProject {
    fun routeToExternalLink(context: Context, link: String)
}