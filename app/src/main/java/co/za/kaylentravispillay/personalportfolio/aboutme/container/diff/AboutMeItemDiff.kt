package co.za.kaylentravispillay.personalportfolio.aboutme.container.diff

import androidx.recyclerview.widget.DiffUtil
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeItem

class AboutMeItemDiff : DiffUtil.ItemCallback<UIModelAboutMeItem>() {

    override fun areItemsTheSame(
        oldItem: UIModelAboutMeItem,
        newItem: UIModelAboutMeItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: UIModelAboutMeItem,
        newItem: UIModelAboutMeItem
    ): Boolean {
        return oldItem == newItem
    }
}