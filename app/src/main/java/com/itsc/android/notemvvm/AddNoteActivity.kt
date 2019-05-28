package com.itsc.android.notemvvm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.itsc.android.notemvvm.model.Note
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {
        private  lateinit var titleEditText: EditText
        private  lateinit var descriptionEditText: EditText
        private  lateinit var saveButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        titleEditText = title_et
        descriptionEditText = description_et
        saveButton = save_btn

        saveButton.setOnClickListener {
            val notes = readFields()
            val replyIntent = Intent()
            replyIntent.putExtra("NOTE",notes)
            setResult(Activity.RESULT_OK,replyIntent)
            finish()
        }

    }
    private fun readFields(): Note {
        return Note(
            code = 0,
            title = titleEditText.text.toString(),
            description = descriptionEditText.text.toString())
    }
}
