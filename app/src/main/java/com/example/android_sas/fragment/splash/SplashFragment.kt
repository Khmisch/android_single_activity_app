package com.example.android_sas.fragment.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.android_sas.R
import com.example.android_sas.databinding.ActivityMainBinding
import com.example.android_sas.extension.activityNavController
import com.example.android_sas.extension.navigateSafely
import com.example.android_sas.manager.AuthManager

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countDownTimer()
    }

    private fun countDownTimer() {
        object : CountDownTimer(2000, 1000){
            override fun onTick(millisUntilFinished: Long) { }

            override fun onFinish() {
                when{
                    AuthManager.isAuthorized -> {
                        activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
                    }
                    !AuthManager.isAuthorized -> {
                        activityNavController().navigateSafely(R.id.action_global_authFlowFragment)
                    }
                }
            }
        }.start()
    }
}