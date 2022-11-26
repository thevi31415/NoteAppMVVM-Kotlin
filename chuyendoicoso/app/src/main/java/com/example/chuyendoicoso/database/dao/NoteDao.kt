package com.example.chuyendoicoso.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.chuyendoicoso.model.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)
    @Update
    suspend fun updateNote(note: Note)
    @Delete
    suspend fun deleteNote(note: Note)
    @Query("select * from note_table ")
    fun  getAllNote(): LiveData<List<Note>>

}