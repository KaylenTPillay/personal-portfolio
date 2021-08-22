package co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model

import co.za.kaylentravispillay.personalportfolio.R

data class UIModelAboutMeParagraph(
    override val id: String,
    override val text: String
) : UIModelAboutMeText {

    override val styleRes: Int = R.style.TextAppearance_MaterialComponents_Body1
}