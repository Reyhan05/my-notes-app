package com.reyhan.mynotesapp.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.reyhan.mynotesapp.database.Notes
import com.reyhan.mynotesapp.database.NotesDB
import com.reyhan.mynotesapp.database.NotesDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NotesRepository(application: Application) {
    private val mNotesDao: NotesDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NotesDB.getDatabase(application)
        mNotesDao = db.notesDao()
    }
    fun getAllNotes(): LiveData<List<Notes>> = mNotesDao.getAllNotes()

    fun insert(notes: Notes) {
        executorService.execute{ mNotesDao.insert(notes)}
    }

    fun delete(notes: Notes) {
        executorService.execute{ mNotesDao.delete(notes)}
    }

    fun update(notes: Notes) {
        executorService.execute{ mNotesDao.update(notes)}
    }

}