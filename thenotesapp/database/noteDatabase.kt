package com.example.thenotesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thenotesapp.model.NOTE

@Database(entities = [NOTE::class], version = 1)
abstract class noteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): noteDao

    companion object{
        @Volatile
        private var instance:noteDatabase?= null
        private val LOCK= Any()

        operator fun invoke(context: Context)= instance?:
        synchronized(LOCK){
            instance ?:
            createDatabase(context).also{
                instance= it
            }
        }
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                noteDatabase:: class.java,
                "note_db"
            ).build()
    }
}