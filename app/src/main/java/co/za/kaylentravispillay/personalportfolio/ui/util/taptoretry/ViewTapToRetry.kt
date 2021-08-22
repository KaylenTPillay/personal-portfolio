package co.za.kaylentravispillay.personalportfolio.ui.util.taptoretry

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import co.za.kaylentravispillay.personalportfolio.databinding.TapToRetryLayoutBinding
import co.za.kaylentravispillay.personalportfolio.ui.util.taptoretry.model.UIModelTapToRetry

class ViewTapToRetry : ConstraintLayout {

    private var onTapToRetrySelected: () -> Unit = {}
    private val binding: TapToRetryLayoutBinding = TapToRetryLayoutBinding.inflate(
        LayoutInflater.from(context),
        this
    )

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        initialiseLayout()
    }

    fun setOnTapToRetrySelected(listener: () -> Unit) {
        onTapToRetrySelected = listener
    }

    fun renderWithModel(model: UIModelTapToRetry) {
        renderMessage(model)
        binding.root.setOnClickListener { onTapToRetrySelected.invoke() }
    }

    private fun renderMessage(model: UIModelTapToRetry) {
        binding.tapToRetryMessage.text = model.message
    }

    private fun initialiseLayout() {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}