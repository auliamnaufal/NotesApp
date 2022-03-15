package com.auliamnaufal.notesapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.auliamnaufal.notesapp.data.NoteRepository
import com.auliamnaufal.notesapp.data.local.entity.Notes
import com.auliamnaufal.notesapp.data.local.room.NotesDB
import com.auliamnaufal.notesapp.data.local.room.NotesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    private val notesDao: NotesDao = NotesDB.getDatabase(application).notesDao()
    private val notesRepository: NoteRepository = NoteRepository(notesDao)

    fun insertNotes(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.insertNotes(notes)
        }
    }

}