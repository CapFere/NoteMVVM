package com.itsc.android.notemvvm.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itsc.android.notemvvm.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes WHERE note_id = :id")
    fun getNoteById(id:Int):Note

    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note:Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

}