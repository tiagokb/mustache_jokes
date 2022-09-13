package br.com.tiagokontarski.mustachejokes.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import br.com.tiagokontarski.mustachejokes.connections.getInstance
import br.com.tiagokontarski.mustachejokes.interfaces.JokeDao
import br.com.tiagokontarski.mustachejokes.models.Joke
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewFragmentViewModel : ViewModel() {
    private lateinit var dao: JokeDao

    @OptIn(DelicateCoroutinesApi::class)
    fun initialize(context: Context) {
        GlobalScope.launch {
            dao = getInstance(context).jokeDao()
        }
    }

    fun save(question: String, answer: String) {
        val joke = Joke(question = question, answer = answer)
        dao.insert(joke)
    }
}