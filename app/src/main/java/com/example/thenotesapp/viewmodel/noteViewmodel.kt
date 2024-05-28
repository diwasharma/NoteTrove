package com.example.thenotesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.thenotesapp.model.NOTE
import com.example.thenotesapp.repository.noteRepository
import kotlinx.coroutines.launch

class noteViewmodel(app: Application, private val noteRepository: noteRepository): AndroidViewModel(app) {
    fun addNote(note: NOTE)=
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    fun deletenote(note: NOTE)=
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    fun updatenote(note: NOTE)=
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    fun getAllNotes()=noteRepository.getAllNotes()

    fun searchNote(query: String?) =
        noteRepository.searchNote(query)
}