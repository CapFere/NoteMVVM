package com.itsc.android.notemvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.itsc.android.notemvvm.data.NoteDatabase
import com.itsc.android.notemvvm.model.Note
import com.itsc.android.notemvvm.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {
    private lateinit var noteRepository: NoteRepository
    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        noteRepository = NoteRepository(noteDao)
    }
    fun getNoteById(id:Int): Note = noteRepository.getNoteById(id)

    fun getAllNotes(): LiveData<List<Note>> = noteRepository.getAllNotes()

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        noteRepository.insertNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        noteRepository.insertNote(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        noteRepository.insertNote(note)
    }
}