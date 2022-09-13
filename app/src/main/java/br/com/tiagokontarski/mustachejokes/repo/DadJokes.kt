package br.com.tiagokontarski.mustachejokes.repo

import br.com.tiagokontarski.mustachejokes.connections.RetrofitConnection
import br.com.tiagokontarski.mustachejokes.interfaces.DadJokesEndpoints
import br.com.tiagokontarski.mustachejokes.interfaces.JokeCallback
import br.com.tiagokontarski.mustachejokes.models.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*

class DadJokes {

    private fun getRetrofit(): Retrofit {
        return RetrofitConnection.getRetrofitInstance()
    }

    fun getRandomJoke(jokeCallback: JokeCallback) {

        val call = getRetrofit().create(DadJokesEndpoints::class.java).getRandomJoke("ptbr")
        call.enqueue(object : Callback<Joke> {
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        jokeCallback.onSuccess(it)
                    }

                    return
                }

                jokeCallback.onFailure()
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                jokeCallback.onFailure()
            }
        })
    }
}