package com.example.evoting.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.evoting.databinding.FragmentDetailCandidateBinding
import com.example.evoting.model.DataGetOneCandidateResponse
import com.example.evoting.model.GetOneCandidateNumberResponse
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.view.adapters.SupportinPartiesAdapter
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

        binding.ivBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        return binding.root
    }

    private fun fetchOneCandidateNumberCoroutines(token: String?, id: String) {
        viewModel.getOneCandidateNumber("Bearer $token", id).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    showData(it.data)
                    showDataParties(it.data?.data?.supportingParties!!)
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), "Uh oh, something went wrong!", Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    Log.d("Loading", "Loading")
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun showData(data: GetOneCandidateNumberResponse?) {
        val candidateData: DataGetOneCandidateResponse? = data?.data

        val missions: List<String>? = candidateData?.mission
        var missionText = ""

        missions?.forEachIndexed { index, mission ->
            missionText += "${index + 1}. $mission\n"
        }

        binding.tvNamaCapresValue.text = candidateData?.presidentalCandidateName
        binding.tvNamaCawapresValue.text = candidateData?.vicePresidentalCandidateName
        binding.tvVisiValue.text = candidateData?.vision
        binding.descValue.text = missionText
        Glide.with(this.binding.partyImg)
            .load(candidateData?.imgUrl)
            .fitCenter()
            .into(this.binding.partyImg)
    }

    private fun showDataParties(data: List<String>) {
        val adapter = SupportinPartiesAdapter(data)
        binding.rvSupportingParties.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvSupportingParties.adapter = adapter
    }
}