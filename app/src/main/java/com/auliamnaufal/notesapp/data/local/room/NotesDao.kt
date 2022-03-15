package com.auliamnaufal.notesapp.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.auliamnaufal.notesapp.data.local.entity.Notes

@Dao
interface NotesDao {
    @Insert
    fun addNotes(note: Notes)

    @Query("SELECT * FROM tb_notes")
    fun getAlarm() : LiveData<List<Notes>>
}