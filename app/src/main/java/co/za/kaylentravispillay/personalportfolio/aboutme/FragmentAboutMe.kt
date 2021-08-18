package co.za.kaylentravispillay.personalportfolio.aboutme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.za.kaylentravispillay.personalportfolio.databinding.AboutMeLayoutBinding

class FragmentAboutMe : Fragment() {

    private lateinit var binding: AboutMeLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AboutMeLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }
}