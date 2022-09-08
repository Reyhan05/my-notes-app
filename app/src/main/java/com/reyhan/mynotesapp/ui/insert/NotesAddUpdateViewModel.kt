package com.reyhan.mynotesapp.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.reyhan.mynotesapp.database.Notes
import com.reyhan.mynotesapp.repository.NotesRepository

class NotesAddUpdateViewModel(application: Application) : ViewModel() {
    private val mNotesRepository: NotesRepository = NotesRepository(application)

    fun insert(notes: Notes) {
        mNotesRepository.insert(notes)
    }

    fun delete(notes: Notes) {
        mNotesRepository.delete(notes)
    }

    fun update(notes: Notes) {
        mNotesRepository.update(notes)
    }

}