package br.com.tiagokontarski.mustachejokes.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.tiagokontarski.mustachejokes.R
import br.com.tiagokontarski.mustachejokes.models.Joke

class WritedJokesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val question: TextView = itemView.findViewById(R.id.item_question)
    val answer: TextView = itemView.findViewById(R.id.item_answer)

    fun bind(joke: Joke) {
        question.text = joke.question
        answer.text = joke.answer
    }
}