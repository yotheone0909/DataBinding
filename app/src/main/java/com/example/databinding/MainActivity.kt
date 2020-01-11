package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.databinding.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.viewmodel = ViewModelProviders.of(this)[MainViewModel::class.java]
        binding?.lifecycleOwner = this

    }

    fun onCountTime(view: View) {
        binding?.viewmodel?.countDown(binding?.timeEditText?.text.toString().toLong())
    }
}
