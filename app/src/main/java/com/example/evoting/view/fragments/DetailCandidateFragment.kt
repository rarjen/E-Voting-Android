package com.example.evoting.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.evoting.databinding.FragmentDetailCandidateBinding
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.viewmodel.MyViewModel
import org.koin.android.ext.android.inject

class DetailCandidateFragment : Fragment() {

    private var _binding: FragmentDetailCandidateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MyViewModel by inject()
    private lateinit var pref: SharedPreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCandidateBinding.inflate(inflater, container, false)

        pref = SharedPreferenceHelper
        val savedToken = pref.read(Enum.PREF_NAME.value).toString()
        val candidateId = arguments?.getString("candidateId").toString()

        fetchOneCandidateNumberCoroutines(savedToken, candidateId)

        return binding.root
    }

    private fun fetchOneCandidateNumberCoroutines(token: String?, id: String) {
        viewModel.getOneCandidateNumber("Bearer $token", id).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.d("TESTDATADAPAT", it.data?.data.toString())
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), "Uh oh, something went wrong!", Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    Log.d("Loading", "Loading")
                }
            }
        }
    }
}