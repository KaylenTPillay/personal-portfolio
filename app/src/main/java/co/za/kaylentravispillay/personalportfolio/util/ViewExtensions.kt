package co.za.kaylentravispillay.personalportfolio.util

import co.za.kaylentravispillay.personalportfolio.util.model.UIModelToolbar
import com.google.android.material.appbar.MaterialToolbar

fun MaterialToolbar.renderWithModel(model: UIModelToolbar) {
    title = model.title
}