package co.za.kaylentravispillay.personalportfolio.ui.project.container.diff

import androidx.recyclerview.widget.DiffUtil
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.UIModelProjectItem

class ProjectItemDiff : DiffUtil.ItemCallback<UIModelProjectItem>() {

    override fun areItemsTheSame(
        oldItem: UIModelProjectItem,
        newItem: UIModelProjectItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: UIModelProjectItem,
        newItem: UIModelProjectItem
    ): Boolean {
        return oldItem == newItem
    }
}