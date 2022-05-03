package br.com.tiagokontarski.mustachejokes.daos

import androidx.room.*
import br.com.tiagokontarski.mustachejokes.models.Joke

@Dao
interface JokeDao {

    //CREATE
    @Insert
    fun insertJoke(model: Joke)

    //READ
    @Query("select * from joke where id = :id")
    fun getById(id: String): Joke?

    @Query("select * from joke")
    fun getAll(): List<Joke?>

    //UPDATE
    @Update
    fun update(model: Joke)

    //DELETE
    @Delete
    fun delete(model: Joke)
}