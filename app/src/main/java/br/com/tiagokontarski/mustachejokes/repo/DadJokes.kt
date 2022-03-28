package br.com.tiagokontarski.mustachejokes.repo

import br.com.tiagokontarski.mustachejokes.enums.DadJokesAPI
import br.com.tiagokontarski.mustachejokes.interfaces.DadJokesEndpoints
import br.com.tiagokontarski.mustachejokes.interfaces.JokeCallback
import br.com.tiagokontarski.mustachejokes.models.Joke
import br.com.tiagokontarski.mustachejokes.utils.RetrofitConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class DadJokes {

    private fun getRetrofit(): Retrofit {
        return RetrofitConnection.getRetrofitInstance()
    }

    fun getRandomJoke(jokeCallback: JokeCallback) {
        val call = getRetrofit().create(DadJokesEndpoints::class.java).getRandomJoke()

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