package com.example.databinding

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {

    private val timer = MutableLiveData<String>()
    fun onTime() = timer

    private val onTimeFinished = MutableLiveData<String>()
    fun onTimeFinished() = onTimeFinished

    private var countDownTimer: CountDownTimer? = null

    fun countDown(time: Long) {
        TimeUnit.SECONDS
        onTimeFinished.value = ""
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer.value = (millisUntilFinished / 1000).toInt().toString()
            }

            override fun onFinish() {
                onTimeFinished.value = "Done!!"
            }
        }.start()
    }
}