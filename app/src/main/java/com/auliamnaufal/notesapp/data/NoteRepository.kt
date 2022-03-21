package com.auliamnaufal.notesapp.data

import androidx.lifecycle.LiveData
import com.auliamnaufal.notesapp.data.local.entity.Notes
import com.auliamnaufal.notesapp.data.local.room.NotesDao

class NoteRepository(private val notesDao: NotesDao) {

    val getAllNotes: LiveData<List<Notes>> = notesDao.getAllNotes()

    suspend fun insertNotes(notes: Notes) {
        notesDao.addNotes(notes)
    }

    fun searchNoteByQuery(query: String) : LiveData<List<Notes>> {
        return notesDao.searchNoteByQuery(query)
    }

    val sortByHighPriority: LiveData<List<Notes>> = notesDao.sortByHighPriority()
    val sortByLowPriority: LiveData<List<Notes>> = notesDao.sortByLowPriority()

    suspend fun deleteAllNotes() {
        return notesDao.deleteAllNotes()
    }

    suspend fun deleteNote(note: Notes) {
        return notesDao.deleteNote(note)
    }
}