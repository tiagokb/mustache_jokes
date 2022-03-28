package br.com.tiagokontarski.mustachejokes.interfaces

import br.com.tiagokontarski.mustachejokes.models.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DadJokesEndpoints {

    @Headers("Accept: application/json")
    @GET("/")
    fun getRandomJoke(): Call<Joke>
}