package com.example.evoting.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evoting.R
import com.example.evoting.databinding.FragmentResultBinding
import com.example.evoting.model.DataVotingResultResponse
import com.example.evoting.model.VotingResultResponse
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.view.adapters.VotingResultAdapter
import com.example.evoting.viewmodel.MyViewModel
import org.koin.android.ext.android.inject

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyViewModel by inject()

    private lateinit var pref: SharedPreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)

        pref = SharedPreferenceHelper
        val savedToken = pref.read(Enum.PREF_NAME.value).toString()

        fetchResultCoroutines(savedToken)

        return binding.root

    }


    private fun fetchResultCoroutines(token: String) {
        viewModel.getAllResult("Bearer $token").observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    showData(it.data!!)
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Uh oh something went wrong!", Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun showData(data: VotingResultResponse?) {
        val adapter = VotingResultAdapter()
        adapter.submitVotingResultResponse(data?.data ?: emptyList())
        binding.rvResult.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvResult.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}