package br.com.tiagokontarski.mustachejokes.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity(tableName = "jokes")
data class Joke(

    @ColumnInfo
    @SerializedName("id")
    var id: String,

    @ColumnInfo
    @SerializedName("joke")
    var joke: String,

    @ColumnInfo
    @SerializedName("status")
    var status: Int
)
