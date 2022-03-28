package br.com.tiagokontarski.mustachejokes.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import br.com.tiagokontarski.mustachejokes.R
import br.com.tiagokontarski.mustachejokes.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    private lateinit var jokeButton: Button
    private lateinit var tvJoke: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jokeButton = findViewById(R.id.jokeButton)
        tvJoke = findViewById(R.id.jokeTv)

        jokeButton.setOnClickListener {

            jokeButton.text = getString(R.string.searching)
            viewModel.getJoke()
            jokeButton.isEnabled = false
        }

        viewModel.liveJoke.observe(this, Observer { newJoke ->
            tvJoke.text = newJoke
            jokeButton.isEnabled = true
            jokeButton.text = getString(R.string.tell_me_another_joke);
        })
    }


}