package com.itsc.android.notemvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "note_id")val code:Int,
    @ColumnInfo(name = "note_title")val title:String,
    @ColumnInfo(name = "note_description")val description:String): Serializable