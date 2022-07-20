package com.example.android_sas.fragment.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_sas.R
import com.example.android_sas.databinding.FragmentLoginBinding
import com.example.android_sas.extension.activityNavController
import com.example.android_sas.extension.navigateSafely
import com.example.android_sas.manager.AuthManager

class LoginFragment: Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.bSignin.setOnClickListener {
            AuthManager.isAuthorized = true
            activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
        }

        binding.tvSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }
}