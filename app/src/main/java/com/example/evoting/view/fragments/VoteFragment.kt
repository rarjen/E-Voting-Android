package com.example.evoting.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evoting.databinding.FragmentVoteBinding
import com.example.evoting.model.CandidateNumberResponse
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.view.adapters.CandidatePairNumberAdapter
import com.example.evoting.view.fragments.bottomsheets.VoteConfirmationFragment
import com.example.evoting.viewmodel.MyViewModel
import org.koin.android.ext.android.inject

class VoteFragment : Fragment() {

    private var _binding : FragmentVoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var pref: SharedPreferenceHelper

    private val viewModel: MyViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVoteBinding.inflate(inflater, container, false)

        pref = SharedPreferenceHelper
        val savedToken = pref.read(Enum.PREF_NAME.value).toString()

        fetchCandidateNumberCoroutines(savedToken)

        return binding.root
    }


    private fun fetchCandidateNumberCoroutines(token: String) {
        viewModel.candidateNumber("Bearer $token", null).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    showCandidate(it.data!!)
                    binding.progressBar.visibility = View.GONE
                }
                Status.ERROR -> {
                    val errMsg = it.data?.message.toString()
                    Toast.makeText(requireContext(), errMsg, Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    Log.d("LOADING", "Loading")
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }


    private fun showCandidate(data: CandidateNumberResponse) {
        val adapter = CandidatePairNumberAdapter(null, onButtonClick = { id ->

            val bottomSheetConfirmation = VoteConfirmationFragment()
            bottomSheetConfirmation.setId(id)
            bottomSheetConfirmation.show(childFragmentManager, bottomSheetConfirmation.tag)
        })

        adapter.submitCandidateNumberResponse(data.data ?: emptyList())
        binding.rvCandidate.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvCandidate.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        super.onDestroyView()
        _binding = null
    }


}