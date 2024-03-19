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

        binding.connectionButton.setOnClickListener {
            SocketHandler.setSocket()
            SocketHandler.establishConnection()

            val mSocket = SocketHandler.getSocket()

            mSocket.on("data_result") { args ->
                if (args[0] != null) {
                    val counter = args[0] as Int
                    requireActivity().runOnUiThread {
                        binding.tv.text = counter.toString()
//                        countTextView.text = counter.toString()
//                        Log.d("SocketEvent", counter.toString())
                    }
                }
            }
        }

        binding.tv.setOnClickListener {
            val data = JSONArray().apply {
                put("data1")
                put("data2")
            }

            SocketHandler.setSocket()
            SocketHandler.establishConnection()

            val mSocket = SocketHandler.getSocket()

            mSocket.emit("data_received", data)
        }

        binding.disconnectButton.setOnClickListener {
//            SocketHandler.closeConnection()

            val crypto = Crypto()
            Log.d("CRYPTO", crypto.encrypt("test"))
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        SocketHandler.disconnect()
//    }
}