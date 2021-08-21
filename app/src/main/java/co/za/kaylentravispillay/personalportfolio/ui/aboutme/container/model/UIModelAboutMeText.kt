package co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model

sealed interface UIModelAboutMeText : UIModelAboutMeItem {
    val text: String
    val styleRes: Int
}