package com.example.evoting.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.evoting.R
import com.example.evoting.databinding.FragmentAkunBinding

class AkunFragment : Fragment() {

    private var _binding : FragmentAkunBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAkunBinding.inflate(inflater, container, false)

        binding.profilSaya.setOnClickListener {
            findNavController().navigate(R.id.action_akunFragment_to_profileFragment)
        }

        binding.ubahPassword.setOnClickListener {
            findNavController().navigate(R.id.action_akunFragment_to_ubahPasswordFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}