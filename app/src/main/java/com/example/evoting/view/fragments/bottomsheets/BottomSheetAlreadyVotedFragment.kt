package com.example.evoting.view.fragments.bottomsheets

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.evoting.databinding.FragmentBottomSheetAlreadyVotedBinding
import com.example.evoting.view.ui.MainActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetAlreadyVotedFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetAlreadyVotedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetAlreadyVotedBinding.inflate(inflater, container, false)

        binding.btnKembali.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
        }

        binding.imageClose.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}