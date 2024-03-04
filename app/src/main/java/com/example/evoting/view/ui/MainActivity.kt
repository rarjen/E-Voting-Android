package com.example.evoting.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evoting.R
import com.example.evoting.databinding.ActivityMainBinding
import com.example.evoting.util.SharedPreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: SharedPreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPreferenceHelper.init(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}