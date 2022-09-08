package com.reyhan.mynotesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1)
abstract class NotesDB : RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object {
        @Volatile
        private var INSTANCE: NotesDB? = null

        @JvmStatic
        fun getDatabase(context: Context): NotesDB {
            if (INSTANCE == null) {
                synchronized(NotesDB::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NotesDB::class.java,
                        "notes_database").build()
                }
            }
            return INSTANCE as NotesDB
        }
    }
}