package com.auliamnaufal.notesapp.data

import com.auliamnaufal.notesapp.data.local.entity.Notes
import com.auliamnaufal.notesapp.data.local.room.NotesDao

class NoteRepository(private val notesDao: NotesDao) {

    suspend fun insertNotes(notes: Notes) {
        notesDao.addNotes(notes)
    }


}