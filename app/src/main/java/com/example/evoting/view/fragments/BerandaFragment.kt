package com.example.evoting.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.evoting.databinding.FragmentBerandaBinding
import com.example.evoting.util.Crypto
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.SocketHandler
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


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}