package com.example.evoting.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.evoting.databinding.FragmentBiographyPersonBinding
import com.example.evoting.model.DataBiography
import com.example.evoting.model.GetBiographyResponse
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.viewmodel.MyViewModel
import org.koin.android.ext.android.inject

class BiographyPersonFragment : Fragment() {

    private var _binding: FragmentBiographyPersonBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MyViewModel by inject()
    private lateinit var pref: SharedPreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBiographyPersonBinding.inflate(inflater, container, false)

        pref = SharedPreferenceHelper
        val savedToken = pref.read(Enum.PREF_NAME.value).toString()
        val presidentialId = arguments?.getString("presidentialId").toString()
        val vicePresidentialId = arguments?.getString("vicePresidentialId").toString()

        getOneBiography(savedToken, presidentialId, vicePresidentialId)

        binding.ivBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        return binding.root
    }

    private fun getOneBiography(token: String, presidentialId: String?, vicePresidentialId: String?) {
        if (presidentialId != null) {
            viewModel.getOnePresidentialClient("Bearer $token", presidentialId).observe(viewLifecycleOwner) {
                when (it.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        showData(it.data)
                        Log.d("TESTDATAGET", it.data.toString())
                    }
                    Status.ERROR -> {
                        val errMsg = it.data?.message.toString()
                        Log.d("TESTDATAERROR", errMsg)
                        binding.progressBar.visibility = View.GONE
                    }
                    Status.LOADING -> {
                        Log.d("LOADING", "Loading")
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        }

        if (vicePresidentialId != null) {
            viewModel.getOneVicePresidentialClient("Bearer $token", vicePresidentialId).observe(viewLifecycleOwner) {
                when (it.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        showData(it.data)
                        Log.d("TESTDATAGET", it.data.toString())
                    }
                    Status.ERROR -> {
                        val errMsg = it.data?.message.toString()
                        Log.d("TESTDATAERROR", errMsg)
                        binding.progressBar.visibility = View.GONE
                    }
                    Status.LOADING -> {
                    Log.d("LOADING", "Loading")
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun showData(data: GetBiographyResponse?) {
        val dataBio: DataBiography? = data?.data

        binding.tvNamaValue.text = dataBio?.name
        binding.tvTtlValue.text = dataBio?.dob
        binding.tvPartyValue.text = dataBio?.namaPartai
        binding.tvDescValue.text = dataBio?.description

        Glide.with(binding.root)
            .load(dataBio?.imgUrl)
            .fitCenter()
            .into(binding.candidateImg)

        Glide.with(binding.root)
            .load(dataBio?.partyImg)
            .fitCenter()
            .into(binding.imgUrlpartyValue)

    }


}