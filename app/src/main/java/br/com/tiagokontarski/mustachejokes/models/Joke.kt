package br.com.tiagokontarski.mustachejokes.models

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("id")
    var id: String,
    @SerializedName("joke")
    var joke: String,
    @SerializedName("status")
    var status: Int
)
