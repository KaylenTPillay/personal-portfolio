package co.za.kaylentravispillay.personalportfolio.ui.approot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import co.za.kaylentravispillay.personalportfolio.R
import co.za.kaylentravispillay.personalportfolio.ui.approot.listener.OnAppRootToolbarListener
import co.za.kaylentravispillay.personalportfolio.databinding.AppRootLayoutBinding
import co.za.kaylentravispillay.personalportfolio.util.extension.getNavigationController
import co.za.kaylentravispillay.personalportfolio.util.model.UIModelToolbar
import co.za.kaylentravispillay.personalportfolio.util.extension.renderWithModel
import com.google.android.material.bottomnavigation.BottomNavigationView

internal class ActivityAppRoot : AppCompatActivity(), OnAppRootToolbarListener {
    private lateinit var binding: AppRootLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupBottomNavigation(
            binding.appRootBottomNavigation,
            supportFragmentManager.getNavigationController(R.id.app_root_container)
        )
    }

    override fun renderToolbarWithModel(model: UIModelToolbar) {
        binding.appRootToolbar.renderWithModel(model)
    }

    private fun setupBinding() {
        binding = AppRootLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupBottomNavigation(
        view: BottomNavigationView,
        navigationController: NavController?
    ) {
        navigationController ?: return
        NavigationUI.setupWithNavController(view, navigationController)
    }
}