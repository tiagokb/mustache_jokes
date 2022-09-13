package br.com.tiagokontarski.mustachejokes.connections

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.tiagokontarski.mustachejokes.interfaces.JokeDao
import br.com.tiagokontarski.mustachejokes.models.Joke

@Database(
    version = 1, entities = [Joke::class],
    exportSchema = false
)
abstract class DbConnection : RoomDatabase() {
    abstract fun jokeDao(): JokeDao
}

private lateinit var INSTANCE: DbConnection

fun getInstance(context: Context): DbConnection {

    if (!::INSTANCE.isInitialized) {
        INSTANCE = Room.databaseBuilder(
            context.applicationContext,
            DbConnection::class.java,
            "database"
        ).allowMainThreadQueries()
            .build()
    }

    return INSTANCE
}
