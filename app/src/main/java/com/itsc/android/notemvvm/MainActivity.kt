package com.itsc.android.notemvvm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.itsc.android.notemvvm.adapter.NoteAdapter
import com.itsc.android.notemvvm.model.Note
import com.itsc.android.notemvvm.viewModel.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var addFAB: FloatingActionButton
    private lateinit var noteViewModel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = NoteAdapter(this)
        recyclerview = recylcer_view
        addFAB = add_fab
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        addFAB.setOnClickListener{
            val intent = Intent(this,AddNoteActivity::class.java)
            startActivityForResult(intent,1)
        }
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        noteViewModel.getAllNotes().observe(this, Observer {
                notes->notes?.let { adapter.setCourses(notes) }
        })
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            data?.let{
                val note:Note = it.getSerializableExtra("NOTE") as Note
                noteViewModel.insertNote(note)
            }
        }
    }
}
