package co.za.kaylentravispillay.personalportfolio.ui.project.container.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import co.za.kaylentravispillay.personalportfolio.databinding.ProjectItemLayoutBinding
import co.za.kaylentravispillay.personalportfolio.ui.project.container.diff.ProjectItemDiff
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.ViewHolderProjectItem
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.UIModelProjectItem
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.adapter.AdapterSpaceAware
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.model.UIModelSpaceAware

class AdapterProject(
    private val onGithubLinkClick: (link: String) -> Unit
) : ListAdapter<UIModelProjectItem, ViewHolderProjectItem>(ProjectItemDiff()), AdapterSpaceAware {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProjectItem {
        val binding = ProjectItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolderProjectItem(binding).apply { setOnGithubLinkListener(onGithubLinkClick) }
    }

    override fun onBindViewHolder(holder: ViewHolderProjectItem, position: Int) {
        val model = currentList[position]
        holder.onBindViewHolder(model)
    }

    override fun getSpaceAwareItemTypeForPosition(position: Int?): Int? {
        return null
    }

    override fun getSpaceAwareItemModelForPosition(position: Int?): UIModelSpaceAware? {
        return position?.let { modelPosition -> currentList.getOrNull(modelPosition) }
    }
}