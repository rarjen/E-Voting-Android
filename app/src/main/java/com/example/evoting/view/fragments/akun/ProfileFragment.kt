package com.example.evoting.view.fragments.akun

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.evoting.R
import com.example.evoting.databinding.FragmentProfileBinding
import com.example.evoting.model.AuthMeResponse
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.viewmodel.MyViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var pref: SharedPreferenceHelper

    private val viewModel: MyViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        pref = SharedPreferenceHelper
        val savedToken = pref.read(Enum.PREF_NAME.value).toString()

        fetchUserProfile(savedToken)

        binding.ivBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        return binding.root
    }

    private fun fetchUserProfile(token: String){
        viewModel.authMeAuth("Bearer $token").observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { data -> showProfile(data) }
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), "Uh oh, something went wrong!", Toast.LENGTH_SHORT).show()
                    Log.d("ERRORPROFILE", it.data?.message.toString())
                }
                Status.LOADING -> {
                    Log.d("LOADING", "Loading")
                }
            }
        }
    }

    private fun showProfile(data: AuthMeResponse) {
        val name = data.data?.name
        val nik = data.data?.nik
        val address = data.data?.address ?: ""
        val email = data.data?.email

        val nameEditable = Editable.Factory.getInstance().newEditable(name)
        val nikEditable = Editable.Factory.getInstance().newEditable(nik)
        val addressEditable = Editable.Factory.getInstance().newEditable(address)
        val emailEditable = Editable.Factory.getInstance().newEditable(email)

        binding.nameField.editText?.text = nameEditable
        binding.addressField.editText?.text = addressEditable
        binding.nikField.editText?.text = nikEditable
        binding.emailField.editText?.text = emailEditable

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}