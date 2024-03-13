package com.example.evoting.view.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.evoting.databinding.ActivityLoginBinding
import com.example.evoting.model.LoginRequest
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.util.Status
import com.example.evoting.view.ui.MainActivity
import com.example.evoting.view.ui.register.RegisterActivity
import com.example.evoting.viewmodel.MyViewModel
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyViewModel by inject()
    private lateinit var pref: SharedPreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = SharedPreferenceHelper
        val token = pref.read(Enum.PREF_NAME.value)
        if (token != null) {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            val nik = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            postLogin(nik, password)
        }
    }

    private fun postLogin(nik: String, password: String){
        val loginRequest = LoginRequest(nik, password)
        viewModel.login(loginRequest).observe(this){
            when (it.status) {
                Status.SUCCESS -> {
                    val token = it.data?.data?.token.toString()
                    pref.write(Enum.PREF_NAME.value, token)

                    val msg = it.data?.message.toString()
                    Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_SHORT).show()

                    navigateToMainActivity()
                }
                Status.ERROR -> {
                    val errMsg = it.message ?: "Error Occurred"
                    Toast.makeText(this@LoginActivity, errMsg, Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    Log.d("LoadingTEST", "Loading")
                    binding.btnLogin.isEnabled = false
                    binding.btnLogin.isActivated = false
                }
            }
        }
    }

    private fun navigateToMainActivity() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }
}