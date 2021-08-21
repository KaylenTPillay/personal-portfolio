package co.za.kaylentravispillay.personalportfolio.aboutme.container.viewholder.header

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
            bindHeaderProfilePicture(model)
            bindHeaderProfileTitle(model)
            bindHeaderProfileSubtitle(model)
        }
    }

    private fun bindHeaderProfilePicture(model: UIModelAboutMeHeader) {
        binding.aboutMeHeaderProfilePicture.load(model.profileThumbnail) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
    }

    private fun bindHeaderProfileTitle(model: UIModelAboutMeHeader) {
        binding.aboutMeHeaderProfileTitle.text = model.profileName
    }

    private fun bindHeaderProfileSubtitle(model: UIModelAboutMeHeader) {
        binding.aboutMeHeaderProfileSubtitle.text = model.profileProfessionalTitle
    }
}