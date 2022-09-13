package br.com.tiagokontarski.mustachejokes.interfaces

import androidx.room.*
import br.com.tiagokontarski.mustachejokes.models.Joke

@Dao
interface JokeDao {

    @Query("SELECT * FROM joke WHERE _id = :id")
    fun get(id: String): Joke?

    @Query("SELECT * FROM joke")
    fun getAll(): List<Joke>

    @Query("SELECT * FROM joke WHERE _id IN (:jokesIds)")
    fun loadAllByIds(jokesIds: IntArray): List<Joke>

    @Query(
        "SELECT * FROM joke WHERE question LIKE :keyWord"
    )
    fun search(keyWord: String): Joke

    @Insert
    fun insert(joke: Joke)

    @Update
    fun update(joke: Joke)

    @Delete
    fun delete(joke: Joke)
}