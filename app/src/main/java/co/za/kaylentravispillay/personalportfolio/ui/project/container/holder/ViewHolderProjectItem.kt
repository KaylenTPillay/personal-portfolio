package co.za.kaylentravispillay.personalportfolio.ui.project.container.holder

import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import co.za.kaylentravispillay.personalportfolio.databinding.ProjectItemLayoutBinding
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.UIModelProjectItem
import co.za.kaylentravispillay.personalportfolio.ui.util.resourcedimension.ResourceDimension

class ViewHolderProjectItem(
    private val binding: ProjectItemLayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

    init {
        initialiseSkelly()
    }

    private var onGithubLinkClick: (link: String) -> Unit = {}

    fun onBindViewHolder(model: UIModelProjectItem) {
        bindLoading(model)
        if (model.isLoading) return

        bindTitle(model)
        bindDescription(model)
        bindWatchers(model)
        bindStars(model)

        binding.root.setOnClickListener {
            onGithubLinkClick.invoke(model.link)
        }
    }

    fun setOnGithubLinkListener(listener: (link: String) -> Unit) {
        onGithubLinkClick = listener
    }

    private fun bindLoading(model: UIModelProjectItem) {
        binding.projectItemTitle.isInvisible = model.isLoading
        binding.projectItemDescription.isInvisible = model.isLoading
        binding.projectItemStar.isInvisible = model.isLoading
        binding.projectItemWatcher.isInvisible = model.isLoading

        binding.projectItemSkelly.isInvisible = !model.isLoading
        binding.projectItemSkelly.enableShimmer(model.isLoading)
    }

    private fun bindTitle(model: UIModelProjectItem) {
        binding.projectItemTitle.isVisible = model.isTitleActive
        if (model.isTitleActive) {
            binding.projectItemTitle.text = model.title
        }
    }

    private fun bindDescription(model: UIModelProjectItem) {
        binding.projectItemDescription.isVisible = model.isDescriptionActive
        if (model.isDescriptionActive) {
            binding.projectItemDescription.text = model.description
        }
    }

    private fun bindWatchers(model: UIModelProjectItem) {
        binding.projectItemWatcher.text = model.watchersDisplayText
    }

    private fun bindStars(model: UIModelProjectItem) {
        binding.projectItemStar.text = model.starsDisplayText
    }

    private fun initialiseSkelly() {
        val dimen8 = ResourceDimension.getDimensions().dimen8
        val dimen16 = ResourceDimension.getDimensions().dimen16
        val dimen48 = dimen16 * 3

        binding.projectItemSkelly.buildSkelly {
            bone {
                height { dimen16 }
            }
            bone {
                marginTop { dimen8 }
                height { dimen16 * 2 }
            }
            horizontalBoneStack {
                marginTop { dimen8 }
                bone {
                    width { dimen48 }
                }
                bone {
                    marginStart { dimen8 }
                    width { dimen48 }
                }
            }
        }
    }
}