package br.com.tiagokontarski.mustachejokes.viewmodels

import android.os.Handler
import androidx.lifecycle.ViewModel

class SplashScreenViewModel : ViewModel() {

    private val handler = Handler()
    private lateinit var runnable: Runnable

    private fun setRunnable(block: () -> Unit) {
        this.runnable = Runnable {
            block()
        }
    }

    fun delayedTransiction(block: () -> Unit) {
        setRunnable(block)
        handler.postDelayed(runnable, 3500)
    }

    fun dismissHandler() {
        handler.removeCallbacks(runnable)
    }
}