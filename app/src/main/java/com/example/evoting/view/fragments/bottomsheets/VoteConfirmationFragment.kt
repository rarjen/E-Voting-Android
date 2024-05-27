package com.example.evoting.view.fragments.bottomsheets

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.evoting.R
import com.example.evoting.databinding.FragmentVoteConfirmationBinding
import com.example.evoting.model.DataGetOneCandidateResponse
import com.example.evoting.model.GetOneCandidateNumberResponse
import com.example.evoting.model.VoteRequest
import com.example.evoting.util.Crypto
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.SocketHandler
import com.example.evoting.util.Status
import com.example.evoting.view.ui.MainActivity
import com.example.evoting.viewmodel.MyViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.android.ext.android.inject

class VoteConfirmationFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentVoteConfirmationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyViewModel by inject()

    private var id: String? = null

    private lateinit var pref: SharedPreferenceHelper

    fun setId(id: String) {
        this.id = id
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVoteConfirmationBinding.inflate(inflater, container, false)

        pref = SharedPreferenceHelper
        val savedToken = pref.read(Enum.PREF_NAME.value).toString()

        fetchOneCandidateNumberCoroutines(savedToken, this.id!!)

        SocketHandler.setSocket()
        SocketHandler.establishConnection()

        binding.buttonYa.setOnClickListener {
            val mSocket = SocketHandler.getSocket()
            mSocket.emit("new_vote", id.toString())

            val encryptedId = Crypto().encrypt(this.id!!)

            Log.d("ENCRYPTED DATA ID USER", encryptedId)
            postVoteCoroutines(savedToken, encryptedId)
        }

        val mSocket = SocketHandler.getSocket()
        mSocket.on("new_vote") { args ->
            val candidateId = args[0] as String

            if (candidateId == id.toString()) {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Anda sudah melakukan vote!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.buttonBatal.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

    private fun fetchOneCandidateNumberCoroutines(token: String?, id: String) {
        viewModel.getOneCandidateNumber("Bearer $token", id).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { data -> showData(data) }
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), "Uh oh, something went wrong!", Toast.LENGTH_SHORT).show()
                    dismiss()
                }
                Status.LOADING -> {
                    Log.d("Loading", "Loading")
                }
            }
        }
    }

    private fun postVoteCoroutines(token: String, id: String) {
        val voteRequest = VoteRequest(id)
        viewModel.vote("Bearer $token", voteRequest).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    startActivity(Intent(requireActivity(), MainActivity::class.java))
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), "Uh oh something went wrong!", Toast.LENGTH_SHORT).show()
                    binding.buttonYa.isEnabled = false
                    binding.buttonYa.isActivated = false
                    binding.buttonBatal.isEnabled = false
                    binding.buttonBatal.isActivated = false
                }
                Status.LOADING -> {
                    Log.d("Loading", "Loading")
                    binding.buttonYa.isEnabled = false
                    binding.buttonYa.isActivated = false
                    binding.buttonBatal.isEnabled = false
                    binding.buttonBatal.isActivated = false
                }
            }
        }
    }

    private fun showData(data: GetOneCandidateNumberResponse) {
        val candidateData: DataGetOneCandidateResponse? = data.data

        binding.capresTV.text = candidateData?.presidentalCandidateName.toString()
        binding.cawapresTV.text = candidateData?.vicePresidentalCandidateName.toString()
        binding.candidateNumber.text = candidateData?.number.toString()
        Glide.with(this)
            .load(candidateData?.imgUrl)
            .fitCenter()
            .into(binding.candidateImg)

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}