package com.reyhan.mynotesapp.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.reyhan.mynotesapp.database.Notes
import com.reyhan.mynotesapp.repository.NotesRepository

class MainViewModel(application: Application) : ViewModel() {
    private val mNotesRepository: NotesRepository = NotesRepository(application)

    fun getAllNotes(): LiveData<List<Notes>> = mNotesRepository.getAllNotes()
}