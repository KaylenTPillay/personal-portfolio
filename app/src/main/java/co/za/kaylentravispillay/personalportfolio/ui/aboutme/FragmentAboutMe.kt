package co.za.kaylentravispillay.personalportfolio.ui.aboutme

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.adapter.AdapterAboutMe
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.viewmodel.ViewModelAboutMe
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.viewmodel.factory.ViewModelFactoryAboutMe
import co.za.kaylentravispillay.personalportfolio.ui.approot.listener.OnAppRootToolbarListener
import co.za.kaylentravispillay.personalportfolio.databinding.AboutMeLayoutBinding
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.maxwidth.ItemDecorationMaxWidth
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.ItemDecorationSpaceAware

class FragmentAboutMe : Fragment() {

    private var onAppRootToolbarListener: OnAppRootToolbarListener? = null
    private lateinit var binding: AboutMeLayoutBinding

    private val viewModel: ViewModelAboutMe by viewModels {
        ViewModelFactoryAboutMe()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        onAppRootToolbarListener = context as? OnAppRootToolbarListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AboutMeLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialiseContainer()
        initialiseTapToRetry()
        observeViewModel()
        viewModel.init()
    }

    private fun initialiseContainer() {
        val context = context ?: return
        binding.aboutMeContainer.adapter = AdapterAboutMe()
        binding.aboutMeContainer.layoutManager = LinearLayoutManager(context)

        if (binding.aboutMeContainer.itemDecorationCount == 0) {
            binding.aboutMeContainer.addItemDecoration(ItemDecorationMaxWidth())
            binding.aboutMeContainer.addItemDecoration(ItemDecorationSpaceAware())
        }
    }

    private fun initialiseTapToRetry() {
        binding.aboutMeTapToRetry.setOnTapToRetrySelected {
            viewModel.onTapToRetryClick()
        }
    }

    private fun observeViewModel() {
        viewModel.toolbarObservable.observe(viewLifecycleOwner) { model ->
            onAppRootToolbarListener?.renderToolbarWithModel(model)
        }

        viewModel.contentObservable.observe(viewLifecycleOwner) { content ->
            setErrorVisibility(false)
            (binding.aboutMeContainer.adapter as? AdapterAboutMe)?.submitList(content)
        }

        viewModel.tapToRetryObservable.observe(viewLifecycleOwner) { model ->
            setErrorVisibility(true)
            binding.aboutMeTapToRetry.renderWithModel(model)
        }
    }

    private fun setErrorVisibility(show: Boolean) {
        binding.aboutMeTapToRetry.isInvisible = !show
        binding.aboutMeContainer.isInvisible = show
    }
}