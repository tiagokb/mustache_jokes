package br.com.tiagokontarski.mustachejokes.viewmodels

import android.content.Context
import androidx.lifecycle.*
import br.com.tiagokontarski.mustachejokes.connections.getInstance
import br.com.tiagokontarski.mustachejokes.interfaces.JokeDao
import br.com.tiagokontarski.mustachejokes.models.Joke
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch

class WritedFragmentViewModel : ViewModel() {

    private lateinit var dao: JokeDao

    val liveJokes: MutableLiveData<List<Joke>> by lazy {
        MutableLiveData<List<Joke>>()
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun initialize(context: Context) {
        viewModelScope.launch {
            dao = getInstance(context).jokeDao()
            emit(dao.getAll())
        }
    }

    private fun emit(jokes: List<Joke>) {
        liveJokes.postValue(jokes)
    }
}