package com.itsc.android.notemvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.itsc.android.notemvvm.model.Note

@Database(entities = arrayOf(Note::class),version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao():NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context):NoteDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,"note_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}