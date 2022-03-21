package com.auliamnaufal.notesapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
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

    val sortByHighPriority: LiveData<List<Notes>> = notesRepository.sortByHighPriority
    val sortByLowPriority: LiveData<List<Notes>> = notesRepository.sortByLowPriority


    fun getAllNotes() : LiveData<List<Notes>> = notesRepository.getAllNotes

    fun insertNotes(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.insertNotes(notes)
        }
    }

    fun searchNoteByQuery(query: String) : LiveData<List<Notes>> {
        return notesRepository.searchNoteByQuery(query)
    }

    fun deleteAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.deleteAllNotes()
        }
    }

    fun deleteNote(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.deleteNote(notes)
        }
    }

}