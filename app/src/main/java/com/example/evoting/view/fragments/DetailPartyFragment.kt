package com.example.evoting.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.evoting.R
import com.example.evoting.databinding.FragmentBerandaBinding
import com.example.evoting.databinding.FragmentDetailPartyBinding
import com.example.evoting.model.DataGetOneParty
import com.example.evoting.model.GetOnePartyResponse
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.viewmodel.MyViewModel
import org.koin.android.ext.android.inject

class DetailPartyFragment : Fragment() {

    private var _binding: FragmentDetailPartyBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MyViewModel by inject()
    private lateinit var pref: SharedPreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailPartyBinding.inflate(inflater, container, false)

        pref = SharedPreferenceHelper
        val savedToken = pref.read(Enum.PREF_NAME.value).toString()
        val partyId = arguments?.getString("partyId").toString()

        showDetailPartyCoroutines(savedToken, partyId)

        binding.ivBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        return binding.root
    }

    private fun showDetailPartyCoroutines(token: String?, id: String) {
        viewModel.getOnePartyClient("Bearer $token", id).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("DETAILPARTY", it.data?.data.toString())
                    showData(it.data)
                }

                Status.ERROR -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Uh oh something went wrong", Toast.LENGTH_SHORT).show()
                    Log.d("ERRORDETAILPARTY", it.message.toString())
                }

                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("LOADING", "Loading")

                }
            }
        }
    }

    private fun showData(data: GetOnePartyResponse?) {
        val partyData: DataGetOneParty? = data?.data

        binding.tvValueNamaPartai.text = partyData?.abbreviation
        binding.tvValueFullNamaPartai.text = partyData?.name
        binding.tvValueDesc.text = partyData?.description
        Glide.with(this.binding.partyImg)
            .load(partyData?.imgUrl)
            .fitCenter()
            .into(this.binding.partyImg)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}