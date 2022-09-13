package br.com.tiagokontarski.mustachejokes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.tiagokontarski.mustachejokes.R
import br.com.tiagokontarski.mustachejokes.holders.WritedJokesViewHolder
import br.com.tiagokontarski.mustachejokes.models.Joke

class WritedJokesAdapter(private val jokes: List<Joke>) :
    RecyclerView.Adapter<WritedJokesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WritedJokesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.writed_rv_item, parent, false)
        return WritedJokesViewHolder(view)
    }

    override fun onBindViewHolder(holder: WritedJokesViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    override fun getItemCount(): Int {
        return jokes.size
    }
}