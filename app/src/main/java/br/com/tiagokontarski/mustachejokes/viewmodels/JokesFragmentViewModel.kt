package br.com.tiagokontarski.mustachejokes.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tiagokontarski.mustachejokes.connections.getInstance
import br.com.tiagokontarski.mustachejokes.interfaces.JokeCallback
import br.com.tiagokontarski.mustachejokes.interfaces.JokeDao
import br.com.tiagokontarski.mustachejokes.models.Joke
import br.com.tiagokontarski.mustachejokes.repo.DadJokes
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class JokesFragmentViewModel : ViewModel() {

    private lateinit var dao: JokeDao

    @OptIn(DelicateCoroutinesApi::class)
    fun initialize(context: Context) {
        GlobalScope.launch {
            dao = getInstance(context).jokeDao()
        }
    }

    private val dadJokes: DadJokes = DadJokes()

    val liveJoke: MutableLiveData<Joke?> by lazy {
        MutableLiveData<Joke?>()
    }

    fun getJoke() {
        dadJokes.getRandomJoke(object : JokeCallback {
            override fun onSuccess(joke: Joke) {
                liveJoke.value = joke
            }

            override fun onFailure() {
                liveJoke.value = null
            }
        })
    }
}