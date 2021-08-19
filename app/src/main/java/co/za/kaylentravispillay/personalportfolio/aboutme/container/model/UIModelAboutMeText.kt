package co.za.kaylentravispillay.personalportfolio.aboutme.container.model

sealed interface UIModelAboutMeText : UIModelAboutMeItem {
    val text: String
    val styleRes: Int
}