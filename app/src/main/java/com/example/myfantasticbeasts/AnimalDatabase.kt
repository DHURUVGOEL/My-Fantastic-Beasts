package com.example.myfantasticbeasts

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Animals::class),version = 1, exportSchema = false)
abstract class AnimalDatabase: RoomDatabase()  {

    abstract fun getAnimalDao(): AnimalDao
    companion object{
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AnimalDatabase? = null

        fun getDatabase(context: Context): AnimalDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnimalDatabase::class.java,
                    "animal_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}