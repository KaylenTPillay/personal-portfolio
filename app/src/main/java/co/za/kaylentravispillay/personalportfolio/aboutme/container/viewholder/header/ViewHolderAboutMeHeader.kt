package co.za.kaylentravispillay.personalportfolio.aboutme.container.viewholder.header

import co.za.kaylentravispillay.personalportfolio.R
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeHeader
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeItem
import co.za.kaylentravispillay.personalportfolio.aboutme.container.viewholder.base.ViewHolderAboutMe
import co.za.kaylentravispillay.personalportfolio.databinding.AboutMeHeaderLayoutBinding
import coil.load
import coil.transform.CircleCropTransformation

class ViewHolderAboutMeHeader(
    private val binding: AboutMeHeaderLayoutBinding
) : ViewHolderAboutMe(binding.root) {

    override fun onBindViewHolder(model: UIModelAboutMeItem) {
        if (model is UIModelAboutMeHeader) {
            bindHeaderBackground(model)
            bindHeaderProfilePicture(model)
        }
    }

    private fun bindHeaderBackground(model: UIModelAboutMeHeader) {
        binding.aboutMeHeaderBackground.load(model.background) {
            crossfade(true)
            error(R.drawable.ic_material_placeholder)
        }
    }

    private fun bindHeaderProfilePicture(model: UIModelAboutMeHeader) {
        binding.aboutMeHeaderProfilePicture.load(model.profileThumbnail) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
    }
}