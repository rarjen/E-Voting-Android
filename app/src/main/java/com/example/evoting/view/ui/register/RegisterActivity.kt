package com.example.evoting.view.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.evoting.R
import com.example.evoting.databinding.ActivityRegisterBinding
import com.example.evoting.model.RegisterRequest
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.view.ui.MainActivity
import com.example.evoting.view.ui.login.LoginActivity
import com.example.evoting.viewmodel.MyViewModel
import org.koin.android.ext.android.inject

class RegisterActivity : AppCompatActivity() {

    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyViewModel by inject()

    private lateinit var pref: SharedPreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = SharedPreferenceHelper

        val token = SharedPreferenceHelper.read(Enum.PREF_NAME.value)
        if (token != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.buttonRegister.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val nik = binding.etNIK.text.toString()
            val name = binding.etNama.text.toString()
            val password = binding.etPassword.text.toString()
            postRegister(nik, email, name, password)
        }
    }

    private fun postRegister(nik: String, email: String, name: String, password: String){
        val registerRequest = RegisterRequest(nik, email, name, password)
        viewModel.register(registerRequest).observe(this){
            when (it.status){
                Status.SUCCESS -> {
                    navigateToLoginActivity()
                }
                Status.ERROR -> {
                    val errorMsg = it.message ?: "Error Occurred"
                    Toast.makeText(this@RegisterActivity, "Error: $errorMsg", Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    binding.buttonRegister.isEnabled = false
                    binding.buttonRegister.isActivated = false
                    Log.d("LOADING", "Loading Register")
                }
            }
        }
    }

    private fun navigateToLoginActivity(){
        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        finish()
    }





}