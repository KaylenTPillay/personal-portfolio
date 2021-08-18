package co.za.kaylentravispillay.personalportfolio.approot

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import co.za.kaylentravispillay.personalportfolio.approot.viewmodel.ViewModelAppRoot
import co.za.kaylentravispillay.personalportfolio.approot.viewmodel.factory.ViewModelFactoryAppRoot
import co.za.kaylentravispillay.personalportfolio.databinding.AppRootLayoutBinding

internal class ActivityAppRoot : AppCompatActivity() {
    private lateinit var binding: AppRootLayoutBinding
    private val viewModel: ViewModelAppRoot by viewModels { ViewModelFactoryAppRoot() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AppRootLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.init()
    }
}