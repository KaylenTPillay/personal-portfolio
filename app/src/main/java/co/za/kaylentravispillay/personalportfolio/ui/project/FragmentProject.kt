package co.za.kaylentravispillay.personalportfolio.ui.project

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import co.za.kaylentravispillay.personalportfolio.databinding.ProjectLayoutBinding
import co.za.kaylentravispillay.personalportfolio.ui.approot.listener.OnAppRootToolbarListener
import co.za.kaylentravispillay.personalportfolio.ui.project.container.adapter.AdapterProject
import co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.ViewModelProject
import co.za.kaylentravispillay.personalportfolio.ui.project.viewmodel.factory.ViewModelFactoryProject
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.maxwidth.ItemDecorationMaxWidth
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.ItemDecorationSpaceAware
import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.adapter.AdapterSpaceAware

class FragmentProject : Fragment() {

    private var onAppRootToolbarListener: OnAppRootToolbarListener? = null
    private lateinit var binding: ProjectLayoutBinding

    private val viewModel: ViewModelProject by viewModels {
        ViewModelFactoryProject()
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
        binding = ProjectLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialiseContainer()
        observeViewModel()
        viewModel.init()
    }

    private fun initialiseContainer() {
        binding.projectContainer.adapter = AdapterProject { link ->
            viewModel.onGithubLinkClick(link)
        }
        binding.projectContainer.layoutManager = LinearLayoutManager(context)
        if (binding.projectContainer.itemDecorationCount == 0) {
            binding.projectContainer.addItemDecoration(ItemDecorationSpaceAware())
            binding.projectContainer.addItemDecoration(ItemDecorationMaxWidth())
        }
    }

    private fun observeViewModel() {
        viewModel.toolbarObservable.observe(viewLifecycleOwner) { model ->
            onAppRootToolbarListener?.renderToolbarWithModel(model)
        }

        viewModel.projectItemObservable.observe(viewLifecycleOwner) { items ->
            (binding.projectContainer.adapter as? AdapterProject)?.submitList(items)
        }
    }
}