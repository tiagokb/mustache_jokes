package br.com.tiagokontarski.mustachejokes.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tiagokontarski.mustachejokes.connections.DbConnection
import br.com.tiagokontarski.mustachejokes.interfaces.JokeCallback
import br.com.tiagokontarski.mustachejokes.models.Joke
import br.com.tiagokontarski.mustachejokes.repo.DadJokes
import java.lang.ref.WeakReference

class MainActivityViewModel : ViewModel() {

    private val dadJokes: DadJokes = DadJokes()

    private lateinit var weakContext: WeakReference<Context>
    fun setContext(context: Context) {
        this.weakContext = WeakReference(context)
    }

    private val jokeDao = weakContext.get()?.let { DbConnection.getInstance(it).jokeDao() }

    private var joke: Joke? = null
    fun setJoke(joke: Joke) {
        this.joke = joke
    }

    val liveJoke: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun setFavorite() {
    }

    fun getJoke() {
        dadJokes.getRandomJoke(object : JokeCallback {
            override fun onSuccess(joke: Joke) {
                liveJoke.value = joke.joke
            }

            override fun onFailure() {
                liveJoke.value = "Ops, Tente novamente!"
            }
        })
    }
}