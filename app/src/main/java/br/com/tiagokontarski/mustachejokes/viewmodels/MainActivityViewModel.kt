package br.com.tiagokontarski.mustachejokes.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tiagokontarski.mustachejokes.interfaces.JokeCallback
import br.com.tiagokontarski.mustachejokes.models.Joke
import br.com.tiagokontarski.mustachejokes.repo.DadJokes

class MainActivityViewModel : ViewModel() {

    private val dadJokes: DadJokes = DadJokes()

    val liveJoke: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getJoke() {
        dadJokes.getRandomJoke(object : JokeCallback {
            override fun onSuccess(joke: Joke) {
                liveJoke.value = joke.question
            }

            override fun onFailure() {
                liveJoke.value = "Ops, Tente novamente!"
            }
        })
    }
}