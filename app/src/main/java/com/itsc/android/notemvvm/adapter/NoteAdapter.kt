package com.itsc.android.notemvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itsc.android.notemvvm.R
import com.itsc.android.notemvvm.model.Note
import kotlinx.android.synthetic.main.recylcer_item.view.*

class NoteAdapter(val context:Context):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var notes:List<Note> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.recylcer_item,parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.titleTextView.text = note.title
        holder.descriptionTextView.text = note.description
    }

    internal fun setCourses(noteList:List<Note>){
        this.notes = noteList
        notifyDataSetChanged()
    }

    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleTextView = itemView.note_title
        val descriptionTextView = itemView.description_et
    }
}