package com.example.evoting.view.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.evoting.R
import com.example.evoting.databinding.ActivitySplashScreenBinding
import com.example.evoting.model.SplashScreen
import com.example.evoting.util.Enum
import com.example.evoting.util.SharedPreferenceHelper
import com.example.evoting.view.adapters.SplashScreenAdapter
import com.example.evoting.view.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
    private val list = ArrayList<SplashScreen>()
    private val splashScreenAdapter = SplashScreenAdapter(list)
    private var _binding: ActivitySplashScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SharedPreferenceHelper.init(this)
        val savedToken = SharedPreferenceHelper.read(Enum.PREF_NAME.value)
        if (savedToken != null) {
            Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        } else {
            binding.splashScreenSlider.adapter = splashScreenAdapter
            list.addAll(getAllSplashData())
            setupIndicator()
            setCurrentIndicator(1)
            binding.splashScreenSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    setCurrentIndicator(position)
                }
            })
            binding.imageButton.setOnClickListener {
                if (binding.splashScreenSlider.currentItem + 1 < splashScreenAdapter.itemCount) {
                    binding.splashScreenSlider.currentItem += 1
                } else {
                    Intent(applicationContext, MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
            }

            binding.loginButton.setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val indicatorContainer = binding.indicatorContainer
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorContainer.getChildAt(i) as ImageView
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    if (i == index) R.drawable.indicator_active else R.drawable.indicator_inactive
                )
            )
        }
    }

    private fun setupIndicator() {
        val indicatorContainer = binding.indicatorContainer
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT).apply {
            setMargins(8, 0, 8, 0)
        }

        for (i in 0 until splashScreenAdapter.itemCount) {
            val indicator = ImageView(applicationContext).apply {
                setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.indicator_inactive))
                setLayoutParams(layoutParams)
            }
            indicatorContainer.addView(indicator)
        }
    }

    private fun getAllSplashData(): ArrayList<SplashScreen> {
        val desk = resources.getStringArray(R.array.splash_desk)
        val image = resources.obtainTypedArray(R.array.splash_img)
        val listSplash = ArrayList<SplashScreen>()
        for (i in desk.indices) {
            val splash = SplashScreen(desk[i], image.getResourceId(i, -1))
            listSplash.add(splash)
        }
        image.recycle()
        return listSplash
    }
}
