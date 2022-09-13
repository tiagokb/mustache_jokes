package br.com.tiagokontarski.mustachejokes.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class Joke(
    @PrimaryKey
    @SerializedName("idJoke")
    var idJoke: Int? = null,

    @ColumnInfo
    @SerializedName("_id")
    var _id: String = "",

    @ColumnInfo
    @SerializedName("question")
    var question: String = "",

    @ColumnInfo
    @SerializedName("answer")
    var answer: String = "",

    @ColumnInfo
    @SerializedName("lang")
    var lang: String = "",

    @ColumnInfo
    @SerializedName("__v")
    var __v: Int = 0,

    @ColumnInfo
    @SerializedName("error")
    var error: String = ""
)

