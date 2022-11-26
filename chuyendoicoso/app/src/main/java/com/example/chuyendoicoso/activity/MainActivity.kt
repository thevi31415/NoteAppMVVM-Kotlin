package com.example.chuyendoicoso.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chuyendoicoso.Adapter.NoteAdapter
import com.example.chuyendoicoso.AddNote2
import com.example.chuyendoicoso.R
import com.example.chuyendoicoso.UpdateNote2
import com.example.chuyendoicoso.model.Note
import com.example.chuyendoicoso.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(this,
            NoteViewModel.NoteViewModelFactory(this.application))[NoteViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControls()
        initEvent()
    }

    private fun initEvent() {
        btn_open_activityadd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddNote2::class.java)
            startActivity(intent)
        //    Toast.makeText(this@MainActivity, "ffff", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initControls() {
        val adapter: NoteAdapter = NoteAdapter(this@MainActivity, onItemClick, onItemDelete)
        recycler1.setHasFixedSize(true)
        recycler1.layoutManager = LinearLayoutManager(this)
        recycler1.adapter = adapter
        noteViewModel.getAllNote().observe(this, Observer {
            adapter.setNotes(it)
        })

    }
    private val onItemClick: (Note)->Unit ={
        val intent = Intent(this, UpdateNote2::class.java)
        intent.putExtra("UPDATE_NOTE", it)
        startActivity(intent)
    }
    private val onItemDelete:(Note)->Unit = {
        noteViewModel.deleteNote(it)
    }
}