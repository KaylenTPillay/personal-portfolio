package co.za.kaylentravispillay.personalportfolio.ui.util.extension

import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import co.za.kaylentravispillay.personalportfolio.ui.util.model.UIModelToolbar
import coil.annotation.ExperimentalCoilApi
import coil.request.ImageRequest
import coil.request.ImageResult
import coil.request.SuccessResult
import coil.transition.Transition
import coil.transition.TransitionTarget
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.*

fun MaterialToolbar.renderWithModel(model: UIModelToolbar) {
    title = model.title
}

@ExperimentalCoilApi
fun ImageRequest.Builder.transitionWithPalette(
    transition: Transition,
    onGeneratePalette: (palette: Palette?) -> Unit
): ImageRequest.Builder {
    return transition(CoilPaletteTransition(transition, onGeneratePalette))
        .allowHardware(false)
}

@ExperimentalCoilApi
private class CoilPaletteTransition(
    private val delegate: Transition? = null,
    private val onGeneratePalette: (palette: Palette?) -> Unit
) : Transition {

    override suspend fun transition(target: TransitionTarget, result: ImageResult) {
        val delegateJob = delegate?.let { delegateTransition ->
            coroutineScope {
                launch(Dispatchers.Main.immediate) {
                    delegateTransition.transition(target, result)
                }
            }
        }

        if (result is SuccessResult) {
            val bitmap = result.drawable.toBitmap()
            val palette = withContext(Dispatchers.IO) {
                Palette.Builder(bitmap).generate()
            }
            onGeneratePalette.invoke(palette)
        }

        delegateJob?.join()
    }
}