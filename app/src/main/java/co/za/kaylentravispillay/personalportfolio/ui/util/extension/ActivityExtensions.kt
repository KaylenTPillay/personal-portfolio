package co.za.kaylentravispillay.personalportfolio.ui.util.extension

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

fun FragmentManager.getNavigationController(@IdRes containerId: Int): NavController? {
    return (findFragmentById(containerId) as? NavHostFragment)?.navController
}