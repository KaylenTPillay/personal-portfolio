package co.za.kaylentravispillay.personalportfolio.aboutme.container.model

import co.za.kaylentravispillay.personalportfolio.R

data class UIModelAboutMeTitle(
    override val id: String,
    override val text: String
) : UIModelAboutMeText{

    override val styleRes: Int = R.style.TextAppearance_MaterialComponents_Headline6
}