package com.reyhan.mynotesapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(notes: Notes)

    @Update
    fun update(notes: Notes)

    @Delete
    fun delete(notes: Notes)

    @Query("SELECT * from notes ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Notes>>
}