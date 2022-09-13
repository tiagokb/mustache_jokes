package br.com.tiagokontarski.mustachejokes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.com.tiagokontarski.mustachejokes.R
import br.com.tiagokontarski.mustachejokes.databinding.FragmentJokesBinding
import br.com.tiagokontarski.mustachejokes.viewmodels.JokesFragmentViewModel

class JokesFragment : Fragment() {

    private var _binding: FragmentJokesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: JokesFragmentViewModel by viewModels()

    private lateinit var randomJokeQuestion: TextView
    private lateinit var randomJokeAnswer: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentJokesBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel.initialize(view.context)

        binding.randomJokeBtn.setOnClickListener {
            binding.randomJokeBtn.showProgress(true)
            binding.randomJokeBtn.isEnabled = false
            viewModel.getJoke()
        }

        randomJokeQuestion = binding.randomJokeQuestion
        randomJokeAnswer = binding.randomJokeAnswer

        viewModel.liveJoke.observe(viewLifecycleOwner, Observer {

            binding.randomJokeBtn.showProgress(false)
            binding.randomJokeBtn.isEnabled = true

            if (it == null) {
                randomJokeQuestion.text = view.resources.getString(R.string.random_joke_fail)
                randomJokeAnswer.text = ""
                return@Observer
            }

            randomJokeQuestion.text = it.question
            randomJokeAnswer.text = it.answer
        })

        return view
    }
}