package br.com.tiagokontarski.mustachejokes.connections

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.tiagokontarski.mustachejokes.daos.JokeDao
import br.com.tiagokontarski.mustachejokes.models.Joke

@Database(entities = [Joke::class], version = 1)
abstract class DbConnection : RoomDatabase() {
    abstract fun jokeDao(): JokeDao

    companion object {
        private lateinit var instance: DbConnection

        @Synchronized
        fun getInstance(context: Context): DbConnection {
            if(!::instance.isInitialized)
                instance = Room.databaseBuilder(context.applicationContext, DbConnection::class.java,
                    "mustache_db")
                    .allowMainThreadQueries()
                    .build()

            return instance

        }
} }