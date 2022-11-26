package com.example.chuyendoicoso.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chuyendoicoso.R
import com.example.chuyendoicoso.model.Note

class NoteAdapter(
    private val context: Context,
    private val onClick: (Note)->Unit,
    private val onDelete:(Note)->Unit
):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var notes: List<Note> = listOf()
    inner class NoteViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        private val txtTitle:TextView = itemview.findViewById(R.id.txt_title)
        private val txtDes: TextView = itemview.findViewById(R.id.txt_des)
        private val btnDelete: Button = itemview.findViewById(R.id.btn_delete)
        private val Layoutitem: RelativeLayout = itemview.findViewById(R.id.layoutitem)
       // private val Txtviewdel : TextView = itemview.findViewById(R.id.txt_title)
        fun onBind(note: Note){
            txtTitle.text = note.title
            txtDes.text = note.description
           // Txtviewdel.setOnClickListener { onDelete(note) }
            btnDelete.setOnClickListener { onDelete(note) }
            Layoutitem.setOnClickListener { onClick(note) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val itemview = LayoutInflater.from(context).inflate(R.layout.activity_item_view2, parent, false)
       return NoteViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       holder.onBind(notes[position])
    }

    override fun getItemCount(): Int {
       return notes.size
    }
    fun setNotes(notes: List<Note>){
        this.notes = notes
        notifyDataSetChanged()
    }
}