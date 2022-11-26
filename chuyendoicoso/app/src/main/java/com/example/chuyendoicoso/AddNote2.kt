package com.example.chuyendoicoso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chuyendoicoso.model.Note
import com.example.chuyendoicoso.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_add_note2.*

class AddNote2 : AppCompatActivity() {
    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(this,
            NoteViewModel.NoteViewModelFactory(this.application))[NoteViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note2)
        btn_add.setOnClickListener {
            val note = Note(edit_note_title.text.toString(), edit_note_des.text.toString())
            noteViewModel.insertNote(note)
            finish()
        }
    }
}