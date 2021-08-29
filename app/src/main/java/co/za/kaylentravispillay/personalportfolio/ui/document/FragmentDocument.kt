package co.za.kaylentravispillay.personalportfolio.ui.document

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.za.kaylentravispillay.personalportfolio.databinding.DocumentLayoutBinding
import co.za.kaylentravispillay.personalportfolio.ui.approot.listener.OnAppRootToolbarListener
import co.za.kaylentravispillay.personalportfolio.ui.document.viewmodel.ViewModelDocument
import co.za.kaylentravispillay.personalportfolio.ui.document.viewmodel.factory.ViewModelFactoryDocument

class FragmentDocument : Fragment() {

    private var onAppRootToolbarListener: OnAppRootToolbarListener? = null
    private lateinit var binding: DocumentLayoutBinding

    private val viewModel: ViewModelDocument by viewModels { ViewModelFactoryDocument() }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        onAppRootToolbarListener = context as? OnAppRootToolbarListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DocumentLayoutBinding.inflate(inflater, container, false)
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