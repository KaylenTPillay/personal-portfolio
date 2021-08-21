package co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.diff.AboutMeItemDiff
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model.*
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.viewholder.base.ViewHolderAboutMe
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.viewholder.header.ViewHolderAboutMeHeader
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.viewholder.text.ViewHolderAboutMeText
import co.za.kaylentravispillay.personalportfolio.databinding.AboutMeHeaderLayoutBinding
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.adapter.AdapterSpaceAware
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.model.UIModelSpaceAware

class AdapterAboutMe : ListAdapter<UIModelAboutMeItem, RecyclerView.ViewHolder>(
    AboutMeItemDiff()
), AdapterSpaceAware {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            UIModelAboutMeItemType.TEXT.ordinal -> createTextViewHolder(parent)
            UIModelAboutMeItemType.HEADER.ordinal -> createHeaderViewHolder(parent)
            else -> createUnknownViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = currentList[position]
        (holder as? ViewHolderAboutMe)?.onBindViewHolder(model)
    }

    override fun getItemViewType(position: Int): Int {
        val model = currentList[position]
        return when (model) {
            is UIModelAboutMeTitle, is UIModelAboutMeParagraph -> UIModelAboutMeItemType.TEXT
            is UIModelAboutMeHeader -> UIModelAboutMeItemType.HEADER
            else -> UIModelAboutMeItemType.UNKNOWN
        }.ordinal
    }

    override fun getSpaceAwareItemTypeForPosition(position: Int?): Int? {
        position ?: return null
        currentList.getOrNull(position) ?: return null
        return getItemViewType(position)
    }

    override fun getSpaceAwareItemModelForPosition(position: Int?): UIModelSpaceAware? {
        position ?: return null
        return currentList.getOrNull(position)
    }

    private fun createTextViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolderAboutMeText(parent.context)
    }

    private fun createHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = AboutMeHeaderLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolderAboutMeHeader(binding)
    }

    private fun createUnknownViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(View(parent.context)) {}
    }
}