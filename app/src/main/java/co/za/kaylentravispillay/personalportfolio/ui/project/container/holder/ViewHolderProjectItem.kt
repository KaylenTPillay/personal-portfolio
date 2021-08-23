package co.za.kaylentravispillay.personalportfolio.ui.project.container.holder

import androidx.recyclerview.widget.RecyclerView
import co.za.kaylentravispillay.personalportfolio.databinding.ProjectItemLayoutBinding
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.UIModelProjectItem

class ViewHolderProjectItem(
    private val binding: ProjectItemLayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

    private var onGithubLinkClick: (link: String) -> Unit = {}

    fun onBindViewHolder(model: UIModelProjectItem) {
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

    private fun bindTitle(model: UIModelProjectItem) {
        binding.projectItemTitle.text = model.title
    }

    private fun bindDescription(model: UIModelProjectItem) {
        binding.projectItemDescription.text = model.description
    }

    private fun bindWatchers(model: UIModelProjectItem) {
        binding.projectItemWatcher.text = model.watchersDisplayText
    }

    private fun bindStars(model: UIModelProjectItem) {
        binding.projectItemStar.text = model.starsDisplayText
    }
}