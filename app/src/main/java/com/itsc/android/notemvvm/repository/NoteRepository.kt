package com.itsc.android.notemvvm.repository

import androidx.lifecycle.LiveData
import com.itsc.android.notemvvm.data.NoteDao
import com.itsc.android.notemvvm.model.Note

class NoteRepository(private val noteDao: NoteDao) {
    fun getNoteById(id:Int):Note = noteDao.getNoteById(id)

    fun getAllNotes(): LiveData<List<Note>> = noteDao.getAllNotes()

    fun insertNote(note:Note) {
        noteDao.insertNote(note)
    }

    fun updateNote(note: Note){
        noteDao.insertNote(note)
    }

    fun deleteNote(note: Note){
        noteDao.insertNote(note)
    }
}