package br.com.tiagokontarski.mustachejokes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.tiagokontarski.mustachejokes.databinding.FragmentNewBinding
import br.com.tiagokontarski.mustachejokes.viewmodels.NewFragmentViewModel

class NewFragment : Fragment() {

    private var _binding: FragmentNewBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewFragmentViewModel by viewModels()

    private lateinit var questionEt: EditText
    private lateinit var answerEt: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel.initialize(view.context)

        questionEt = binding.newQuestionEt
        answerEt = binding.newAnswerEt

        binding.newJokeSave.setOnClickListener {
            if (verificaCampos()) {
                viewModel.save(
                    questionEt.text.toString(),
                    answerEt.text.toString()
                )
            }
        }

        return view
    }

    private fun verificaCampos(): Boolean {
        return (questionEt.text.toString().isNotBlank()
                && questionEt.text.toString().isNotEmpty()
                && answerEt.text.toString().isNotBlank()
                && answerEt.text.toString().isNotEmpty())
    }
}