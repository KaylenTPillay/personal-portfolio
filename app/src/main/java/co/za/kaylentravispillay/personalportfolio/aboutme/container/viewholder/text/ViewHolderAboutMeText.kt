package co.za.kaylentravispillay.personalportfolio.aboutme.container.viewholder.text

import android.content.Context
import android.view.ViewGroup
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeItem
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeText
import co.za.kaylentravispillay.personalportfolio.aboutme.container.viewholder.base.ViewHolderAboutMe
import com.google.android.material.textview.MaterialTextView

class ViewHolderAboutMeText(
    context: Context
) : ViewHolderAboutMe(MaterialTextView(context)) {

    init {
        initialiseLayoutParams()
    }

    override fun onBindViewHolder(model: UIModelAboutMeItem) {
        if (itemView is MaterialTextView && model is UIModelAboutMeText) {
            bindTextStyle(itemView, model.styleRes)
            bindTitle(itemView, model)
        }
    }

    private fun bindTitle(view: MaterialTextView, model: UIModelAboutMeText) {
        view.text = model.text
    }

    private fun initialiseLayoutParams() {
        itemView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}