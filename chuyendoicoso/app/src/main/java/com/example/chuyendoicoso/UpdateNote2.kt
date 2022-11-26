package com.example.chuyendoicoso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chuyendoicoso.model.Note
import com.example.chuyendoicoso.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_add_note2.*
import kotlinx.android.synthetic.main.activity_add_note2.edit_note_des
import kotlinx.android.synthetic.main.activity_add_note2.edit_note_title
import kotlinx.android.synthetic.main.activity_update_note2.*

class UpdateNote2 : AppCompatActivity() {
    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(this,
            NoteViewModel.NoteViewModelFactory(this.application))[NoteViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note2)
        val note = intent.getSerializableExtra("UPDATE_NOTE") as Note
        edit_note_title.setText(note.title)
        edit_note_des.setText(note.description)
        btn_update.setOnClickListener {
            note.title = edit_note_title.text.toString()
            note.description = edit_note_des.text.toString()
            noteViewModel.updatetNote(note)
            finish()
        }
    }
}