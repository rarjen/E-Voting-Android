package com.example.evoting.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.evoting.R
import com.example.evoting.databinding.ActivityMainBinding
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.SocketHandler
import com.example.evoting.util.Status
import com.example.evoting.view.fragments.bottomsheets.BottomSheetAlreadyVotedFragment
import com.example.evoting.viewmodel.MyViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MyViewModel by inject()
    private lateinit var pref: SharedPreferenceHelper

    private var isVoted: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPreferenceHelper.init(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = SharedPreferenceHelper
        val savedToken = pref.read(Enum.PREF_NAME.value).toString()

        fetchUserCoroutines(savedToken)

        SocketHandler.setSocket()
        SocketHandler.establishConnection()

        val navHomeFragment = supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment
        val navController = navHomeFragment.navController
        val navView: BottomNavigationView = binding.bottomNavigation
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            if (isVoted == 1) {
               when (destination.id) {
                   R.id.voteFragment -> {
                       val bottomSheetAlreadyVotedFragment = BottomSheetAlreadyVotedFragment()
                       bottomSheetAlreadyVotedFragment.show(supportFragmentManager, bottomSheetAlreadyVotedFragment.tag)
                       navController.navigate(R.id.berandaFragment2)
                   }
               }
            }
        }

    }

    private fun fetchUserCoroutines (token: String) {
        viewModel.authMeAuth("Bearer $token").observe(this@MainActivity) {
            when (it.status) {
                Status.SUCCESS -> {
                    isVoted = it.data?.data?.isVoted!!
                    Log.d("isVoted", isVoted.toString())
                }
                Status.ERROR -> {
                    val errMsg = it.data?.message.toString()
                    Toast.makeText(this@MainActivity, errMsg, Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    Log.d("LOADING", "Loading")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        SocketHandler.closeConnection()
    }

}