package com.example.chuyendoicoso.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.chuyendoicoso.database.dao.NoteRespository
import com.example.chuyendoicoso.model.Note
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):ViewModel() {
private val noteRespository: NoteRespository = NoteRespository(application)
  fun insertNote(note: Note) = viewModelScope.launch {
      noteRespository.insertNote(note)
  }
    fun updatetNote(note: Note) = viewModelScope.launch {
        noteRespository.updatetNote(note)
    }
    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRespository.deleteNote(note)
    }
    fun getAllNote(): LiveData<List<Note>> = noteRespository.getAllNote()
    class NoteViewModelFactory(private val application: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(NoteViewModel::class.java))
            {
                @Suppress("UNCHECKED_CAST")
                return NoteViewModel(application) as T
            }
            throw  IllegalAccessException("Unable construct viewModel")
        }
    }
}