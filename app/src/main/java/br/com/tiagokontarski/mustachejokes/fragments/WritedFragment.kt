package br.com.tiagokontarski.mustachejokes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.tiagokontarski.mustachejokes.adapters.WritedJokesAdapter
import br.com.tiagokontarski.mustachejokes.databinding.FragmentWritedBinding
import br.com.tiagokontarski.mustachejokes.viewmodels.WritedFragmentViewModel

class WritedFragment : Fragment() {

    private var _binding: FragmentWritedBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WritedFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWritedBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel.initialize(view.context)

        viewModel.liveJokes.observe(viewLifecycleOwner, Observer {
            binding.writedRv.layoutManager = LinearLayoutManager(view.context)
            binding.writedRv.adapter = WritedJokesAdapter(it)
        })

        return view
    }
}
