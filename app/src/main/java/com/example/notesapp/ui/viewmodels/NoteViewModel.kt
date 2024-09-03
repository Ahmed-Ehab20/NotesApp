package com.example.notesapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.database.Note
import com.example.notesapp.database.RoomDBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val db = RoomDBHelper.getInstance(application)

    fun upsert(n: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            db.dao.upsertNote(n)
        }
    }

    fun delete(n: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            db.dao.deleteNote(n)
        }
    }

    fun getNotes() = db.dao.getNotes()
}
