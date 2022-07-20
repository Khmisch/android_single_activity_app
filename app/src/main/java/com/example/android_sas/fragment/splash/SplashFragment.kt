package com.example.android_sas.fragment.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.android_sas.R
import com.example.android_sas.databinding.ActivityMainBinding
import com.example.android_sas.manager.AuthManager

class SplashFragment: Fragment(R.layout.fragment_splash) {
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        Handler(Looper.myLooper()!!).postDelayed({
            when{
                AuthManager.isAuthorized -> {
                    navGraph.setStartDestination(R.id.mainFlowFragment)
                }
                !AuthManager.isAuthorized -> {
                    navGraph.setStartDestination(R.id.authFlowFragment)
                }
            }

        },3000)
        navController.graph = navGraph

    }
}