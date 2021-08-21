package co.za.kaylentravispillay.personalportfolio.ui.document

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.za.kaylentravispillay.personalportfolio.databinding.DocumentLayoutBinding

class FragmentDocument : Fragment() {

    private lateinit var binding: DocumentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DocumentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }
}