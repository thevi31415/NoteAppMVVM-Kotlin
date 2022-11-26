package com.example.chuyendoicoso.database.dao

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.chuyendoicoso.model.Note

class NoteRespository(app:Application) {
    private val noteDao: NoteDao
    init{
        val noteDatabase: NoteDatabase = NoteDatabase.getInstance(app)
        noteDao = noteDatabase.getNotDao()
    }
    suspend fun insertNote(note: Note) = noteDao.insertNote(note)
    suspend fun updatetNote(note: Note) = noteDao.updateNote(note)
    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
    fun  getAllNote(): LiveData<List<Note>> = noteDao.getAllNote()
}