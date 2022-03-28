package br.com.tiagokontarski.mustachejokes.interfaces

import br.com.tiagokontarski.mustachejokes.models.Joke

interface JokeCallback {

    fun onSuccess(joke: Joke)

    fun onFailure();
}
