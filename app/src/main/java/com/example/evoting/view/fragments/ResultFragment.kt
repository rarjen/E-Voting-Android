package com.example.evoting.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evoting.databinding.FragmentResultBinding
import com.example.evoting.model.DataVotingResultResponse
import com.example.evoting.util.SocketHandler
import com.example.evoting.view.adapters.VotingResultAdapter
import org.json.JSONArray

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val data = mutableListOf<DataVotingResultResponse>()

    private lateinit var adapter: VotingResultAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)

        adapter = VotingResultAdapter()

        val mSocket = SocketHandler.getSocket()

        mSocket.on("data_update") { args ->
            val dataArray = args[0] as JSONArray
            val newData = mutableListOf<DataVotingResultResponse>()

            for (i in 0 until dataArray.length()) {
                val jsonObject = dataArray.getJSONObject(i)
                val votingResult = DataVotingResultResponse(
                    jsonObject.getString("candidate_pair_number_id"),
                    jsonObject.getString("id"),
                    jsonObject.getString("img_result"),
                    jsonObject.getInt("number"),
                    jsonObject.getDouble("percentage"),
                    jsonObject.getString("presidental_name"),
                    jsonObject.getInt("total_vote"),
                    jsonObject.getString("vice_presidental_name")
                )
                newData.add(votingResult)
            }

            if (isAdded && !isDetached) {
                requireActivity().runOnUiThread{
                    data.clear() // Membersihkan data sebelum menambahkan data baru
                    data.addAll(newData) // Menambahkan data baru ke data yang sudah bersih
                    showData(data)
                    binding.progressBar.visibility = View.GONE
                }
            }

        }



        return binding.root

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun showData(data: List<DataVotingResultResponse> ) {
        adapter.submitVotingResultResponse(data)
        binding.rvResult.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvResult.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}