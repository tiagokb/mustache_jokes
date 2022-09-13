package br.com.tiagokontarski.mustachejokes.interfaces

import br.com.tiagokontarski.mustachejokes.models.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DadJokesEndpoints {

    @GET("/puzzle")
    fun getRandomJoke(@Query("lang") lang: String): Call<Joke>
}