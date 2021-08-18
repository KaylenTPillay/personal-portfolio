package co.za.kaylentravispillay.personalportfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.za.kaylentravispillay.personalportfolio.databinding.AppRootLayoutBinding

internal class ActivityAppRoot : AppCompatActivity() {
    private lateinit var binding: AppRootLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AppRootLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appRootToolbar.title = "Example toolbar"
    }
}