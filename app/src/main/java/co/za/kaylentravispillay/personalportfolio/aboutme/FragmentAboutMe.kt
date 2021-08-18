package co.za.kaylentravispillay.personalportfolio.aboutme

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel.ViewModelAboutMe
import co.za.kaylentravispillay.personalportfolio.aboutme.viewmodel.factory.ViewModelFactoryAboutMe
import co.za.kaylentravispillay.personalportfolio.approot.listener.OnAppRootToolbarListener
import co.za.kaylentravispillay.personalportfolio.databinding.AboutMeLayoutBinding

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

        observeViewModel()
        viewModel.init()
    }

    private fun observeViewModel() {
        viewModel.toolbarObservable.observe(viewLifecycleOwner) { model ->
            onAppRootToolbarListener?.renderToolbarWithModel(model)
        }
    }
}