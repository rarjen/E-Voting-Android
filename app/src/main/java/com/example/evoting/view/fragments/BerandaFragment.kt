package com.example.evoting.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evoting.databinding.FragmentBerandaBinding
import com.example.evoting.model.GetAllPartiesResponse
import com.example.evoting.util.Crypto
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.SocketHandler
import com.example.evoting.util.Status
import com.example.evoting.view.adapters.PartiesAdapter
import com.example.evoting.viewmodel.MyViewModel
import io.socket.client.Socket
import io.socket.emitter.Emitter
import org.json.JSONArray
import org.json.JSONObject
import org.koin.android.ext.android.inject

class BerandaFragment : Fragment() {

    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MyViewModel by inject()
    private lateinit var pref: SharedPreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBerandaBinding.inflate(inflater, container, false)

        pref = SharedPreferenceHelper
        val savedToken = pref.read(Enum.PREF_NAME.value).toString()

        authMe(savedToken)
        fetchParties(savedToken)


        return binding.root
    }


    private fun fetchParties(token: String?) {
        viewModel.getAllPartiesClient("Bearer $token").observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    showParties(it.data!!)
                    binding.progressBarParties.visibility = View.GONE
                }

                Status.ERROR -> {
                    Log.d("BERANDATEST", "Error Occured: ${it.message}")
                    Toast.makeText(requireContext(), "Uh oh something went wrong", Toast.LENGTH_SHORT).show()
                    binding.progressBarParties.visibility = View.VISIBLE

                }

                Status.LOADING -> {
                    Log.d("BERANDATEST", "Error Occured!")
                    binding.progressBarParties.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun authMe(token: String?) {
        viewModel.authMeAuth("Bearer $token").observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.tvValueName.text = it.data?.data?.name
                }

                Status.ERROR -> {
                    Log.d("AUTHME", "${it.message}")
                    binding.tvValueName.text = null
                }

                Status.LOADING -> {
                    Log.d("AUTHME", "LOADING")
                    binding.tvValueName.text = null
                }
            }
        }
    }

    private fun showParties(data: GetAllPartiesResponse?) {
        val adapter = PartiesAdapter()
        adapter.submitAllParties(data?.data ?: emptyList())
        binding.rvPartai.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvPartai.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}