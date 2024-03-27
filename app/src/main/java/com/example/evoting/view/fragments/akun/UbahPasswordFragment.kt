package com.example.evoting.view.fragments.akun

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.evoting.R
import com.example.evoting.databinding.FragmentUbahPasswordBinding
import com.example.evoting.model.ResetPasswordRequest
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.viewmodel.MyViewModel
import org.koin.android.ext.android.inject

class UbahPasswordFragment : Fragment() {

    private var _binding : FragmentUbahPasswordBinding? = null
    private val binding get() = _binding!!

    private lateinit var pref: SharedPreferenceHelper

    private val viewModel: MyViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUbahPasswordBinding.inflate(inflater, container, false)

        pref = SharedPreferenceHelper
        val savedToken = pref.read(Enum.PREF_NAME.value).toString()

        binding.ivBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.btnUpdatePassword.setOnClickListener {
            val oldPassword = binding.passwordLama.editText?.text.toString()
            val newPassword = binding.passwordBaru.editText?.text.toString()
            val repeatPassword = binding.repeatPassword.editText?.text.toString()
            postResetPassword(savedToken, oldPassword, newPassword, repeatPassword)
        }

        return binding.root
    }

    private fun postResetPassword(token: String?, oldPassword: String, newPassword: String, confirmPassword: String) {
        val resetPasswordRequest = ResetPasswordRequest(oldPassword, newPassword, confirmPassword)
        viewModel.resetPassword("Bearer $token", resetPasswordRequest).observe(viewLifecycleOwner){
            when (it.status){
                Status.SUCCESS -> {
                    Toast.makeText(requireContext(), "Success ubah password!", Toast.LENGTH_SHORT).show()
                    binding.passwordLama.editText?.text = null
                    binding.passwordBaru.editText?.text = null
                    binding.repeatPassword.editText?.text = null
                }
                Status.ERROR -> {
                    val errorMsg = it.message ?: "Error Occurred"
                    Log.d("ERRORFETCH", errorMsg)
                    Toast.makeText(requireContext(), "Uh oh something went wrong", Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    Log.d("LOADING", "Loading Register")
                    binding.btnUpdatePassword.isEnabled = false
                    binding.btnUpdatePassword.isActivated = false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}