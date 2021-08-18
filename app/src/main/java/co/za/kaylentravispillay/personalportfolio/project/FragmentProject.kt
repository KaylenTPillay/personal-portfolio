package co.za.kaylentravispillay.personalportfolio.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.za.kaylentravispillay.personalportfolio.databinding.ProjectLayoutBinding

class FragmentProject : Fragment() {

    private lateinit var binding: ProjectLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProjectLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }
}