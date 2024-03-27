package com.example.evoting.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evoting.R
import com.example.evoting.databinding.FragmentBerandaBinding
import com.example.evoting.model.CandidateNumberResponse
import com.example.evoting.model.GetAllPartiesResponse
import com.example.evoting.model.GetAllPresidentialResponse
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.view.adapters.GetAllPairNumberAdapter
import com.example.evoting.view.adapters.PartiesAdapter
import com.example.evoting.view.adapters.ProfilePresidentialCandidateAdapter
import com.example.evoting.viewmodel.MyViewModel
import com.google.android.material.tabs.TabLayout
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

        setupTabLayout(savedToken)
        setupTabLayoutNomor(savedToken)
        fetchParties(savedToken)


        return binding.root
    }


    private fun setupTabLayout(token: String?) {
        fetchPresidential(token)
        val tabLayout = binding.tabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Calon Presiden"))
        tabLayout.addTab(tabLayout.newTab().setText("Calon Wakil Presiden"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (it.position) {
                        0 -> fetchPresidential(token)
                        1 -> fetchVicePresidential(token)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Not needed for this example
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Not needed for this example
            }
        })
    }

    private fun setupTabLayoutNomor(token: String?) {
        fetchCandidateNumberCoroutines(token, "1")
        val tabLayout = binding.tabLayoutNomerUrut
        tabLayout.addTab(tabLayout.newTab().setText("No. 1"))
        tabLayout.addTab(tabLayout.newTab().setText("No. 2"))
        tabLayout.addTab(tabLayout.newTab().setText("No. 3"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (it.position) {
                        0 -> fetchCandidateNumberCoroutines(token, "1")
                        1 -> fetchCandidateNumberCoroutines(token, "2")
                        2 -> fetchCandidateNumberCoroutines(token, "3")
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Not needed for this example
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Not needed for this example
            }
        })
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

    private fun fetchPresidential(token: String?) {
        viewModel.getAllPresindentialClient("Bearer $token").observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBarCapres.visibility = View.GONE
                    showPresidential(it.data!!)
                }

                Status.ERROR -> {
                    Log.d("BERANDATEST", "Error Occured: ${it.message}")
                    Toast.makeText(requireContext(), "Uh oh something went wrong", Toast.LENGTH_SHORT).show()
                    binding.progressBarCapres.visibility = View.VISIBLE

                }

                Status.LOADING -> {
                    Log.d("BERANDATEST", "Error Occured!")
                    binding.progressBarCapres.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun fetchVicePresidential(token: String?) {
        viewModel.getAllVicePresidentialClient("Bearer $token").observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBarCapres.visibility = View.GONE
                    showVicePresidential(it.data!!)
                }

                Status.ERROR -> {
                    Log.d("BERANDATEST", "Error Occured: ${it.message}")
                    Toast.makeText(requireContext(), "Uh oh something went wrong", Toast.LENGTH_SHORT).show()
                    binding.progressBarCapres.visibility = View.VISIBLE

                }

                Status.LOADING -> {
                    Log.d("BERANDATEST", "Error Occured!")
                    binding.progressBarCapres.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun fetchCandidateNumberCoroutines(token: String?, number: String?) {
        viewModel.candidateNumber("Bearer $token", number).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    showCandidate(it.data!!)
                    binding.progressBarCawapres.visibility = View.GONE
                }
                Status.ERROR -> {
                    val errMsg = it.data?.message.toString()
                    Toast.makeText(requireContext(), errMsg, Toast.LENGTH_SHORT).show()
                    binding.progressBarCawapres.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    Log.d("LOADING", "Loading")
                    binding.progressBarCawapres.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun showParties(data: GetAllPartiesResponse?) {
        val adapter = PartiesAdapter(object: PartiesAdapter.OnItemClickListener {
            override fun onItemClick(id: String) {
                val bundle = Bundle().apply {
                    putString("partyId", id)
                }

                findNavController().navigate(
                    R.id.action_berandaFragment2_to_detailPartyFragment,
                    bundle
                )
            }

        })
        adapter.submitAllParties(data?.data ?: emptyList())
        binding.rvPartai.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvPartai.adapter = adapter
    }

    private fun showPresidential(data: GetAllPresidentialResponse?) {
        val adapter = ProfilePresidentialCandidateAdapter(object: ProfilePresidentialCandidateAdapter.OnItemClickListener{
            override fun onItemClick(id: String) {
                val bundle = Bundle().apply {
                    putString("presidentialId", id)
                }
                findNavController().navigate(
                    R.id.action_berandaFragment2_to_biographyPersonFragment,
                    bundle
                )
            }

        })
        adapter.submitAllPresidential(data?.data ?: emptyList())
        binding.rvCapres.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCapres.adapter = adapter
    }

    private fun showVicePresidential(data: GetAllPresidentialResponse?) {
        val adapter = ProfilePresidentialCandidateAdapter(object: ProfilePresidentialCandidateAdapter.OnItemClickListener{
            override fun onItemClick(id: String) {
                val bundle = Bundle().apply {
                    putString("vicePresidentialId", id)
                }
                findNavController().navigate(
                    R.id.action_berandaFragment2_to_biographyPersonFragment,
                    bundle
                )
            }

        })
        adapter.submitAllPresidential(data?.data ?: emptyList())
        binding.rvCapres.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCapres.adapter = adapter
    }

    private fun showCandidate(data: CandidateNumberResponse) {
        val adapter =  GetAllPairNumberAdapter(object: GetAllPairNumberAdapter.OnItemClickListener {
            override fun onItemClick(id: String) {
                val bundle = Bundle().apply {
                    putString("candidateId", id)
                }
                findNavController().navigate(
                    R.id.action_berandaFragment2_to_detailCandidateFragment,
                    bundle
                )
            }
        })
        adapter.submitData(data.data ?: emptyList())
        binding.rvCawapres.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvCawapres.adapter = adapter

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}