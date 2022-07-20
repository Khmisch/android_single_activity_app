package com.example.android_sas.fragment.auth.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_sas.R
import com.example.android_sas.databinding.FragmentLoginBinding
import com.example.android_sas.databinding.FragmentSignupBinding
import com.example.android_sas.extension.activityNavController
import com.example.android_sas.extension.navigateSafely
import com.example.android_sas.manager.AuthManager

class SignupFragment : Fragment(R.layout.fragment_signup) {
    private val binding by viewBinding(FragmentSignupBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.bSignup.setOnClickListener {
            AuthManager.isAuthorized = true
            activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
        }

        binding.tvSignin.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}